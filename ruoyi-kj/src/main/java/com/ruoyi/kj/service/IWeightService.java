package com.ruoyi.kj.service;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.kj.domain.Weight;

import java.util.List;

/**
 * 称重信息Service接口
 *
 * @author weiliang
 * @date 2022-04-14
 */
public interface IWeightService
{
    /**
     * 查询称重信息
     *
     * @param weightId 称重信息主键
     * @return 称重信息
     */
    public Weight selectWeightByWeightId(Long weightId);

    public JSONObject selectVideoByWeightId(Long weightId);

    /**
     * 查询称重信息列表
     *
     * @param weight 称重信息
     * @return 称重信息集合
     */
    public List<Weight> selectWeightList(Weight weight);

    /**
     * 新增称重信息
     *
     * @param weight 称重信息
     * @return 结果
     */
    public AjaxResult insertWeight(Weight weight);

    public int insertWeightManual(Weight weight);

    /**
     * 修改称重信息
     *
     * @param weight 称重信息
     * @return 结果
     */
    public int updateWeight(Weight weight);

    public int updateWeightManual(Weight weight);

    /**
     * 批量删除称重信息
     *
     * @param weightIds 需要删除的称重信息主键集合
     * @return 结果
     */
    public int deleteWeightByWeightIds(Long[] weightIds);

    /**
     * 删除称重信息信息
     *
     * @param weightId 称重信息主键
     * @return 结果
     */
    public int deleteWeightByWeightId(Long weightId);
}
