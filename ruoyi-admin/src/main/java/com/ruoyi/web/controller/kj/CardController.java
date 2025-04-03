package com.ruoyi.web.controller.kj;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.kj.domain.Card;
import com.ruoyi.kj.domain.Weight;
import com.ruoyi.kj.mapper.WeightMapper;
import com.ruoyi.kj.service.ICardService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 卡号信息Controller
 *
 * @author weiliang
 * @date 2022-02-21
 */
@RestController
@RequestMapping("/kj/card")
public class CardController extends BaseController {
    @Autowired
    private ICardService cardService;

    @Autowired
    private WeightMapper weightMapper;

    /**
     * 查询卡号信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:card:list')")
    @GetMapping("/list")
    public TableDataInfo list(Card card) {
        startPage();
        List<Card> list = cardService.selectCardList(card);
        return getDataTable(list);
    }

    /**
     * 导出卡号信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:card:export')")
    @Log(title = "卡号信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Card card) {
        List<Card> list = cardService.selectCardList(card);
        ExcelUtil<Card> util = new ExcelUtil<Card>(Card.class);
        util.exportExcel(response, list, "卡号信息数据");
    }

    /**
     * 获取卡号信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('kj:card:query')")
    @GetMapping(value = "/{cardId}")
    public AjaxResult getInfo(@PathVariable("cardId") Long cardId) {
        return AjaxResult.success(cardService.selectCardByCardId(cardId));
    }

    /**
     * 获取根据卡号获取车号
     */
    @PreAuthorize("@ss.hasPermi('kj:card:query')")
    @GetMapping(value = "/getCarNumber")
    public AjaxResult getInfo(@RequestParam("cardNumber") String cardNumber, @RequestParam("intervals") long intervals) {
        // 查询卡号是否有车辆信息
        String carNumber = cardService.selectCarNumberByCardNumber(cardNumber);
        if (StringUtils.isNull(carNumber)) {
            return AjaxResult.success("无卡号信息");
        }
        // 查询最后一次称重记录
        Weight lastWeight = weightMapper.selectWeightByCardNumber(cardNumber);
        if (lastWeight != null) {
            // 判断时间是否小于称重间隔时间，重复过磅
            Date currentDate = DateUtils.getNowDate();// 当前时间
            long lastTime = lastWeight.getFinish() == 0 ? lastWeight.getFirstTime().getTime() : lastWeight.getSecondTime().getTime();
            if (currentDate.getTime() < lastTime + intervals * 60 * 1000) {
                return AjaxResult.success("重复过磅");
            }
        }
        return AjaxResult.success(carNumber);
    }

    /**
     * 新增卡号信息
     */
    @PreAuthorize("@ss.hasPermi('kj:card:add')")
    @Log(title = "卡号信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Card card) {
        card.setCreateBy(getUsername());
        return toAjax(cardService.insertCard(card));
    }

    /**
     * 修改卡号信息
     */
    @PreAuthorize("@ss.hasPermi('kj:card:edit')")
    @Log(title = "卡号信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Card card) {
        card.setUpdateBy(getUsername());
        return toAjax(cardService.updateCard(card));
    }

    /**
     * 删除卡号信息
     */
    @PreAuthorize("@ss.hasPermi('kj:card:remove')")
    @Log(title = "卡号信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{cardIds}")
    public AjaxResult remove(@PathVariable Long[] cardIds) {
        return toAjax(cardService.deleteCardByCardIds(cardIds));
    }

    /**
     * 查询卡号信息下拉选项
     */
    @PreAuthorize("@ss.hasPermi('kj:card:query')")
    @GetMapping("/getOptions")
    @ApiOperation(value = "获取卡号下拉选择列表")
    public AjaxResult getOptions() {
        JSONArray dataArray = new JSONArray();
        List<Card> list = cardService.selectCardList(new Card());
        if (StringUtils.isNotNull(list)) {
            for (Card cd : list) {
                JSONObject item = new JSONObject();
                item.put("value", cd.getCardId());
                item.put("label", cd.getCardNumber());
                dataArray.add(item);
            }
        }
        return AjaxResult.success(dataArray);
    }
}
