package com.ruoyi.web.controller.kj;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.StringUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.kj.domain.Material;
import com.ruoyi.kj.service.IMaterialService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 货物信息Controller
 *
 * @author weiliang
 * @date 2022-04-14
 */
@RestController
@RequestMapping("/kj/material")
public class MaterialController extends BaseController
{
    @Autowired
    private IMaterialService materialService;

    /**
     * 查询货物信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:material:list')")
    @GetMapping("/list")
    public TableDataInfo list(Material material)
    {
        startPage();
        List<Material> list = materialService.selectMaterialList(material);
        return getDataTable(list);
    }

    /**
     * 导出货物信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:material:export')")
    @Log(title = "货物信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Material material)
    {
        List<Material> list = materialService.selectMaterialList(material);
        ExcelUtil<Material> util = new ExcelUtil<Material>(Material.class);
        util.exportExcel(response, list, "货物信息数据");
    }

    /**
     * 获取货物信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('kj:material:query')")
    @GetMapping(value = "/{materialId}")
    public AjaxResult getInfo(@PathVariable("materialId") Long materialId)
    {
        return AjaxResult.success(materialService.selectMaterialByMaterialId(materialId));
    }

    /**
     * 新增货物信息
     */
    @PreAuthorize("@ss.hasPermi('kj:material:add')")
    @Log(title = "货物信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Material material)
    {
        return toAjax(materialService.insertMaterial(material));
    }

    /**
     * 修改货物信息
     */
    @PreAuthorize("@ss.hasPermi('kj:material:edit')")
    @Log(title = "货物信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Material material)
    {
        return toAjax(materialService.updateMaterial(material));
    }

    /**
     * 删除货物信息
     */
    @PreAuthorize("@ss.hasPermi('kj:material:remove')")
    @Log(title = "货物信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{materialIds}")
    public AjaxResult remove(@PathVariable Long[] materialIds)
    {
        return toAjax(materialService.deleteMaterialByMaterialIds(materialIds));
    }

    /**
     * 查询货物信息下拉选项
     */
    @PreAuthorize("@ss.hasPermi('kj:material:query')")
    @GetMapping("/getOptions")
    public AjaxResult getOptions()
    {
        JSONArray dataArray = new JSONArray();
        List<Material> list = materialService.selectMaterialList(new Material());
        if(StringUtils.isNotNull(list)){
            for (Material m:list) {
                JSONObject item = new JSONObject();
                item.put("value", m.getMaterialId());
                item.put("label", m.getMaterialName());
                dataArray.add(item);
            }
        }
        return AjaxResult.success(dataArray);
    }
}
