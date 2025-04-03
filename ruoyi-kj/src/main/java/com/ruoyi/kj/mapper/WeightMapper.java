package com.ruoyi.kj.mapper;

import com.ruoyi.kj.domain.Weight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 称重信息Mapper接口
 *
 * @author weiliang
 * @date 2022-04-14
 */
public interface WeightMapper
{
    /**
     * 查询称重信息
     *
     * @param weightId 称重信息主键
     * @return 称重信息
     */
    public Weight selectWeightByWeightId(Long weightId);

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
    public int insertWeight(Weight weight);

    /**
     * 修改称重信息
     *
     * @param weight 称重信息
     * @return 结果
     */
    public int updateWeight(Weight weight);

    /**
     * 删除称重信息
     *
     * @param weightId 称重信息主键
     * @return 结果
     */
    public int deleteWeightByWeightId(Long weightId);

    /**
     * 批量删除称重信息
     *
     * @param weightIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWeightByWeightIds(Long[] weightIds);

    public Weight selectWeightByCarNumber(@Param("carNumber") String carNumber);

    public Weight selectWeightByCardNumber(@Param("cardNumber") String cardNumber);
}
