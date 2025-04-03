package com.ruoyi.kj.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.kj.domain.Customize1;
import com.ruoyi.kj.mapper.Customize1Mapper;
import com.ruoyi.kj.service.ICustomize1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 区域信息Service业务层处理
 * 
 * @author weiliang
 * @date 2022-11-18
 */
@Service
public class Customize1ServiceImpl implements ICustomize1Service 
{
    @Autowired
    private Customize1Mapper customize1Mapper;

    /**
     * 查询区域信息
     * 
     * @param customize1Id 区域信息主键
     * @return 区域信息
     */
    @Override
    public Customize1 selectCustomize1ByCustomize1Id(Long customize1Id)
    {
        return customize1Mapper.selectCustomize1ByCustomize1Id(customize1Id);
    }

    /**
     * 查询区域信息列表
     * 
     * @param customize1 区域信息
     * @return 区域信息
     */
    @Override
    public List<Customize1> selectCustomize1List(Customize1 customize1)
    {
        return customize1Mapper.selectCustomize1List(customize1);
    }

    @Override
    public List<Customize1> selectCustomize1Options() {
        return customize1Mapper.selectCustomize1Options();
    }

    /**
     * 新增区域信息
     * 
     * @param customize1 区域信息
     * @return 结果
     */
    @Override
    public int insertCustomize1(Customize1 customize1)
    {
        customize1.setCreateTime(DateUtils.getNowDate());
        return customize1Mapper.insertCustomize1(customize1);
    }

    /**
     * 修改区域信息
     * 
     * @param customize1 区域信息
     * @return 结果
     */
    @Override
    public int updateCustomize1(Customize1 customize1)
    {
        customize1.setUpdateTime(DateUtils.getNowDate());
        return customize1Mapper.updateCustomize1(customize1);
    }

    /**
     * 批量删除区域信息
     * 
     * @param customize1Ids 需要删除的区域信息主键
     * @return 结果
     */
    @Override
    public int deleteCustomize1ByCustomize1Ids(Long[] customize1Ids)
    {
        return customize1Mapper.deleteCustomize1ByCustomize1Ids(customize1Ids);
    }

    /**
     * 删除区域信息信息
     * 
     * @param customize1Id 区域信息主键
     * @return 结果
     */
    @Override
    public int deleteCustomize1ByCustomize1Id(Long customize1Id)
    {
        return customize1Mapper.deleteCustomize1ByCustomize1Id(customize1Id);
    }
}
