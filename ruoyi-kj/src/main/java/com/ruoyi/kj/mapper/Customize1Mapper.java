package com.ruoyi.kj.mapper;

import com.ruoyi.kj.domain.Customize1;

import java.util.List;

/**
 * 区域信息Mapper接口
 * 
 * @author weiliang
 * @date 2022-11-18
 */
public interface Customize1Mapper 
{
    /**
     * 查询区域信息
     * 
     * @param customize1Id 区域信息主键
     * @return 区域信息
     */
    public Customize1 selectCustomize1ByCustomize1Id(Long customize1Id);

    /**
     * 查询区域信息列表
     * 
     * @param customize1 区域信息
     * @return 区域信息集合
     */
    public List<Customize1> selectCustomize1List(Customize1 customize1);

    public List<Customize1> selectCustomize1Options();

    /**
     * 新增区域信息
     * 
     * @param customize1 区域信息
     * @return 结果
     */
    public int insertCustomize1(Customize1 customize1);

    /**
     * 修改区域信息
     * 
     * @param customize1 区域信息
     * @return 结果
     */
    public int updateCustomize1(Customize1 customize1);

    /**
     * 删除区域信息
     * 
     * @param customize1Id 区域信息主键
     * @return 结果
     */
    public int deleteCustomize1ByCustomize1Id(Long customize1Id);

    /**
     * 批量删除区域信息
     * 
     * @param customize1Ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCustomize1ByCustomize1Ids(Long[] customize1Ids);
}
