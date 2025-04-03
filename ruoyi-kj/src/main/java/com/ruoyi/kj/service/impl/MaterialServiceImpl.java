package com.ruoyi.kj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kj.mapper.MaterialMapper;
import com.ruoyi.kj.domain.Material;
import com.ruoyi.kj.service.IMaterialService;

/**
 * 货物信息Service业务层处理
 * 
 * @author weiliang
 * @date 2022-04-14
 */
@Service
public class MaterialServiceImpl implements IMaterialService 
{
    @Autowired
    private MaterialMapper materialMapper;

    /**
     * 查询货物信息
     * 
     * @param materialId 货物信息主键
     * @return 货物信息
     */
    @Override
    public Material selectMaterialByMaterialId(Long materialId)
    {
        return materialMapper.selectMaterialByMaterialId(materialId);
    }

    /**
     * 查询货物信息列表
     * 
     * @param material 货物信息
     * @return 货物信息
     */
    @Override
    public List<Material> selectMaterialList(Material material)
    {
        return materialMapper.selectMaterialList(material);
    }

    /**
     * 新增货物信息
     * 
     * @param material 货物信息
     * @return 结果
     */
    @Override
    public int insertMaterial(Material material)
    {
        material.setCreateTime(DateUtils.getNowDate());
        return materialMapper.insertMaterial(material);
    }

    /**
     * 修改货物信息
     * 
     * @param material 货物信息
     * @return 结果
     */
    @Override
    public int updateMaterial(Material material)
    {
        material.setUpdateTime(DateUtils.getNowDate());
        return materialMapper.updateMaterial(material);
    }

    /**
     * 批量删除货物信息
     * 
     * @param materialIds 需要删除的货物信息主键
     * @return 结果
     */
    @Override
    public int deleteMaterialByMaterialIds(Long[] materialIds)
    {
        return materialMapper.deleteMaterialByMaterialIds(materialIds);
    }

    /**
     * 删除货物信息信息
     * 
     * @param materialId 货物信息主键
     * @return 结果
     */
    @Override
    public int deleteMaterialByMaterialId(Long materialId)
    {
        return materialMapper.deleteMaterialByMaterialId(materialId);
    }
}
