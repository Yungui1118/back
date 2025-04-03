package com.ruoyi.kj.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.kj.domain.History;
import com.ruoyi.kj.domain.Weight;
import com.ruoyi.kj.mapper.CarMapperEx;
import com.ruoyi.kj.mapper.CardMapper;
import com.ruoyi.kj.mapper.HistoryMapper;
import com.ruoyi.kj.mapper.WeightMapper;
import com.ruoyi.kj.service.ISequenceServiceEx;
import com.ruoyi.kj.service.IWeightService;
import com.ruoyi.kj.vo.CarVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 称重信息Service业务层处理
 *
 * @author weiliang
 * @date 2022-04-14
 */
@Service
public class WeightServiceImpl implements IWeightService {

    private static Logger log = LoggerFactory.getLogger(IWeightService.class);

    @Autowired
    private WeightMapper weightMapper;

    @Autowired
    private ISequenceServiceEx sequenceServiceEx;

    @Autowired
    private CarMapperEx carMapperEx;

    @Autowired
    private CardMapper cardMapper;

    @Autowired
    private HistoryMapper historyMapper;

    @Qualifier("threadPoolTaskExecutor")
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    /**
     * 查询称重信息
     *
     * @param weightId 称重信息主键
     * @return 称重信息
     */
    @Override
    public Weight selectWeightByWeightId(Long weightId) {
        return weightMapper.selectWeightByWeightId(weightId);
    }

    @Override
    public JSONObject selectVideoByWeightId(Long weightId) {
        Weight weight = weightMapper.selectWeightByWeightId(weightId);
        JSONObject item = new JSONObject();
        item.put("first", getVideoArray(weight.getFirstImg()));
        item.put("second", getVideoArray(weight.getSecondImg()));
        return item;
    }

    public JSONArray getVideoArray(String url) {
        JSONArray valueArr = new JSONArray();
        if (url != null) {
            String[] arr = url.split("\\|");
            valueArr.addAll(Arrays.asList(arr));
        }
        return valueArr;
    }


    /**
     * 查询称重信息列表
     *
     * @param weight 称重信息
     * @return 称重信息
     */
    @Override
    public List<Weight> selectWeightList(Weight weight) {
        return weightMapper.selectWeightList(weight);
    }

    /**
     * 新增称重信息
     *
     * @param weight 称重信息
     * @return 结果
     */
    @Override
    public AjaxResult insertWeight(Weight weight) {
        log.info("自动称重数据:" + weight.toString());
        // 查询最后一次称重记录
        Weight lastWeight = weightMapper.selectWeightByCarNumber(weight.getCarNumber());
        // 有未完成称重记录
        if (lastWeight != null && lastWeight.getFinish() == 0) {
            int weightData = (int) weight.getParams().get("weight");
            int effectiveTime = (int) weight.getParams().get("effectiveTime"); // 称重有效时间 24小时
            String picPath = (String) weight.getParams().get("picPath");
            // 称重重量数据
            BigDecimal number = BigDecimal.valueOf(weightData);

            long firstTime = lastWeight.getFirstTime().getTime();  // 一次过磅时间戳
            Date currentDate = DateUtils.getNowDate();// 当前时间
            // 判断当前时间超出24小时有效时间
            if (currentDate.getTime() > firstTime + (long) effectiveTime * 60 * 60 * 1000) {
                //新增称重记录
                return insertNewWeight(weight);
            }
            lastWeight.setUpdateTime(currentDate);            // 设置更新时间
            lastWeight.setSecondWeight(number);               // 设置二次称重重量
            lastWeight.setSecondTime(currentDate);            // 设置二次称重时间
            lastWeight.setSecondImg(picPath);                 // 设置二次称重图片路径
            lastWeight.setFinish(1);                          // 设置完成标识
            // 净重取绝对值
            BigDecimal net = lastWeight.getFirstWeight().subtract(number).abs();
            lastWeight.setNetWeight(net);                     // 设置净重
            int result = weightMapper.updateWeight(lastWeight);
            HashMap<String, Object> map = new HashMap<>();
            map.put("weightId", lastWeight.getWeightId());
            // 第二次过磅
            map.put("count", 2);
            // 净重
            map.put("net", net);
            if (result > 0) {
                return AjaxResult.success(map);
            } else {
                return AjaxResult.error("失败", map);
            }
        } else {
            return insertNewWeight(weight);
        }
    }

    @Override
    public int insertWeightManual(Weight weight) {
        log.info("手动称重数据:" + weight.toString());
        weight.setWeightSeq(sequenceServiceEx.buildOnlyNumber("2"));  //设置称重编号
        Date now = DateUtils.getNowDate();
        weight.setUpdateTime(now);
        weight.setCreateTime(now);
        if (weight.getFirstWeight() != null && weight.getSecondWeight() != null && weight.getNetWeight() != null) {
            weight.setFinish(1);
        }
        return weightMapper.insertWeight(weight);
    }

    public AjaxResult insertNewWeight(Weight weight) {
        // 根据车号获取到卡号
        // String cardNumber = cardMapper.selectCardByCarNumber(weight.getCarNumber()).getCardNumber();
        int weightData = (int) weight.getParams().get("weight");
        String picPath = (String) weight.getParams().get("picPath");
        CarVo carVo = carMapperEx.selectCarVoListByCarNumber(weight.getCarNumber()); // 根据车号查询车辆信息
        Date currentDate = DateUtils.getNowDate();// 当前时间
        // 称重重量数据
        BigDecimal number = BigDecimal.valueOf(weightData);
        if (carVo == null) {
            return AjaxResult.error("无此车辆信息");
        }
        if (carVo.getMaterialName() != null) {
            weight.setMaterialName(carVo.getMaterialName());
        }
        if (carVo.getShipper() != null) {
            weight.setShipper(carVo.getShipper());
        }
        if (carVo.getTransport() != null) {
            weight.setTransport(carVo.getTransport());
        }
        if (carVo.getReceiver() != null) {
            weight.setReceiver(carVo.getReceiver());
        }
        if (carVo.getCustomize1() != null) {
            weight.setCustomize1(carVo.getCustomize1());
        }
        if (carVo.getCustomize2() != null) {
            weight.setCustomize2(carVo.getCustomize2());
        }
        if (carVo.getCustomize3() != null) {
            weight.setCustomize3(carVo.getCustomize3());
        }
        weight.setWeightSeq(sequenceServiceEx.buildOnlyNumber("2"));  //设置称重编号
        weight.setCreateTime(currentDate);                                  //设置插入时间
        weight.setCreateBy(weight.getUpdateBy());                           //设置过磅人员
        weight.setFirstWeight(number);                                      //设置第一次过磅重量
        weight.setFirstTime(currentDate);                                   //设置第一次过磅时间
        weight.setFirstImg(picPath);                                        //设置第一次过磅图片
        int result = weightMapper.insertWeight(weight);
        // 可以获取到自增id
        Long i = weight.getWeightId();
        HashMap<String, Object> map = new HashMap<>();
        map.put("weightId", i);
        // 第二次过磅
        map.put("count", 1);
        if (result > 0) {
            return AjaxResult.success(map);
        } else {
            return AjaxResult.error("失败", map);
        }
    }

    /**
     * 修改称重信息
     *
     * @param weight 称重信息
     * @return 结果
     */
    @Override
    public int updateWeight(Weight weight) {
        log.info("修改称重数据:" + weight.toString());
        weight.setUpdateTime(DateUtils.getNowDate());
        if (weight.getSecondWeight() != null && weight.getNetWeight() != null) {
            weight.setFinish(1);
        }
        return weightMapper.updateWeight(weight);
    }

    @Override
    public int updateWeightManual(Weight after) {
        Weight original = weightMapper.selectWeightByWeightId(after.getWeightId());

        if (original.getFirstWeight() != null && original.getSecondWeight() != null) {

            StringBuilder originalContent = new StringBuilder();
            StringBuilder afterContent = new StringBuilder();
            if (!original.getCarNumber().equals(after.getCarNumber())) {
                originalContent.append("【车号】").append(original.getCarNumber()).append(" ");
                afterContent.append("【车号】").append(after.getCarNumber()).append(" ");
            }
            if (!original.getMaterialName().equals(after.getMaterialName())) {
                originalContent.append("【货物】").append(original.getMaterialName()).append(" ");
                afterContent.append("【货物】").append(after.getMaterialName()).append(" ");
            }
            if (!original.getShipper().equals(after.getShipper())) {
                originalContent.append("【发货单位】").append(original.getShipper()).append(" ");
                afterContent.append("【发货单位】").append(after.getShipper()).append(" ");
            }
            if (!original.getReceiver().equals(after.getReceiver())) {
                originalContent.append("【收货单位】").append(original.getReceiver()).append(" ");
                afterContent.append("【收货单位】").append(after.getReceiver()).append(" ");
            }
            if (!original.getTransport().equals(after.getTransport())) {
                originalContent.append("【运输单位】").append(original.getTransport()).append(" ");
                afterContent.append("【运输单位】").append(after.getTransport()).append(" ");
            }
            if (original.getFirstWeight().compareTo(after.getFirstWeight()) != 0) {
                originalContent.append("【一次重】").append(original.getFirstWeight().stripTrailingZeros().toPlainString()).append(" ");
                afterContent.append("【一次重】").append(after.getFirstWeight().stripTrailingZeros().toPlainString()).append(" ");
            }
            if (original.getSecondWeight().compareTo(after.getSecondWeight()) != 0) {
                originalContent.append("【二次重】").append(original.getSecondWeight().stripTrailingZeros().toPlainString()).append(" ");
                afterContent.append("【二次重】").append(after.getSecondWeight().stripTrailingZeros().toPlainString()).append(" ");
            }
            if (original.getNetWeight().compareTo(after.getNetWeight()) != 0) {
                originalContent.append("【净重】").append(original.getNetWeight().stripTrailingZeros().toPlainString()).append(" ");
                afterContent.append("【净重】").append(after.getNetWeight().stripTrailingZeros().toPlainString()).append(" ");
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String originalFirstTime = original.getFirstTime() == null ? "": dateFormat.format(original.getFirstTime());
            String originalSecondTime = original.getSecondTime() == null ? "": dateFormat.format(original.getSecondTime());
            String afterFirstTime = after.getFirstTime() == null ? "": dateFormat.format(after.getFirstTime());
            String afterSecondTime = after.getSecondTime() == null ? "": dateFormat.format(after.getSecondTime());

            if (!Objects.equals(originalFirstTime, afterFirstTime)) {
                originalContent.append("【一次重时间】").append(originalFirstTime).append(" ");
                afterContent.append("【一次重时间】").append(afterFirstTime).append(" ");
            }
            if (!Objects.equals(originalSecondTime, afterSecondTime)) {
                originalContent.append("【二次重时间】").append(originalSecondTime).append(" ");
                afterContent.append("【二次重时间】").append(afterSecondTime).append(" ");
            }
            // 记录更新内容
            if (originalContent.length() != 0) {
                History history = new History();
                history.setWeightId(after.getWeightId());
                history.setCreateBy(after.getUpdateBy());
                history.setOriginalContent(originalContent.toString());
                history.setAfterContent(afterContent.toString());

                taskExecutor.execute(() -> {
                    historyMapper.insert(history);
                });
            }
            log.info("[weight修改] original：" + JSON.toJSONString(original));
            log.info("[weight修改] after：" + JSON.toJSONString(after));
        }

        after.setUpdateTime(DateUtils.getNowDate());
        if (after.getSecondWeight() != null && after.getNetWeight() != null) {
            after.setFinish(1);
        }
        return weightMapper.updateWeight(after);
    }

    /**
     * 批量删除称重信息
     *
     * @param weightIds 需要删除的称重信息主键
     * @return 结果
     */
    @Override
    public int deleteWeightByWeightIds(Long[] weightIds) {
        log.info("删除称重数据:" + Arrays.toString(weightIds));
        return weightMapper.deleteWeightByWeightIds(weightIds);
    }

    /**
     * 删除称重信息信息
     *
     * @param weightId 称重信息主键
     * @return 结果
     */
    @Override
    public int deleteWeightByWeightId(Long weightId) {
        return weightMapper.deleteWeightByWeightId(weightId);
    }
}
