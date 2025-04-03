package com.ruoyi.kj.service;

import java.util.List;
import com.ruoyi.kj.domain.Material;

/**
 * 货物信息Service接口
 * 
 * @author weiliang
 * @date 2022-04-14
 */
public interface IMaterialService 
{
    /**
     * 查询货物信息
     * 
     * @param materialId 货物信息主键
     * @return 货物信息
     */
    public Material selectMaterialByMaterialId(Long materialId);

    /**
     * 查询货物信息列表
     * 
     * @param material 货物信息
     * @return 货物信息集合
     */
    public List<Material> selectMaterialList(Material material);

    /**
     * 新增货物信息
     * 
     * @param material 货物信息
     * @return 结果
     */
    public int insertMaterial(Material material);

    /**
     * 修改货物信息
     * 
     * @param material 货物信息
     * @return 结果
     */
    public int updateMaterial(Material material);

    /**
     * 批量删除货物信息
     * 
     * @param materialIds 需要删除的货物信息主键集合
     * @return 结果
     */
    public int deleteMaterialByMaterialIds(Long[] materialIds);

    /**
     * 删除货物信息信息
     * 
     * @param materialId 货物信息主键
     * @return 结果
     */
    public int deleteMaterialByMaterialId(Long materialId);
}
