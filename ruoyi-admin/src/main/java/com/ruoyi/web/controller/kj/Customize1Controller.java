package com.ruoyi.web.controller.kj;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.kj.domain.Customize1;
import com.ruoyi.kj.service.ICustomize1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 区域信息Controller
 * 
 * @author weiliang
 * @date 2022-11-18
 */
@RestController
@RequestMapping("/kj/customize1")
public class Customize1Controller extends BaseController
{
    @Autowired
    private ICustomize1Service customize1Service;

    /**
     * 查询区域信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:customize1:list')")
    @GetMapping("/list")
    public TableDataInfo list(Customize1 customize1)
    {
        startPage();
        List<Customize1> list = customize1Service.selectCustomize1List(customize1);
        return getDataTable(list);
    }

    /**
     * 导出区域信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:customize1:export')")
    @Log(title = "区域信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Customize1 customize1)
    {
        List<Customize1> list = customize1Service.selectCustomize1List(customize1);
        ExcelUtil<Customize1> util = new ExcelUtil<Customize1>(Customize1.class);
        util.exportExcel(response, list, "区域信息数据");
    }

    /**
     * 获取区域信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('kj:customize1:query')")
    @GetMapping(value = "/{customize1Id}")
    public AjaxResult getInfo(@PathVariable("customize1Id") Long customize1Id)
    {
        return AjaxResult.success(customize1Service.selectCustomize1ByCustomize1Id(customize1Id));
    }

    /**
     * 新增区域信息
     */
    @PreAuthorize("@ss.hasPermi('kj:customize1:add')")
    @Log(title = "区域信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Customize1 customize1)
    {
        return toAjax(customize1Service.insertCustomize1(customize1));
    }

    /**
     * 修改区域信息
     */
    @PreAuthorize("@ss.hasPermi('kj:customize1:edit')")
    @Log(title = "区域信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Customize1 customize1)
    {
        return toAjax(customize1Service.updateCustomize1(customize1));
    }

    /**
     * 删除区域信息
     */
    @PreAuthorize("@ss.hasPermi('kj:customize1:remove')")
    @Log(title = "区域信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{customize1Ids}")
    public AjaxResult remove(@PathVariable Long[] customize1Ids)
    {
        return toAjax(customize1Service.deleteCustomize1ByCustomize1Ids(customize1Ids));
    }

    /**
     * 查询区域信息下拉选项
     */
    @PreAuthorize("@ss.hasPermi('kj:customize1:query')")
    @GetMapping("/getOptions")
    public AjaxResult getOptions()
    {
        JSONArray dataArray = new JSONArray();
        List<Customize1> list = customize1Service.selectCustomize1Options();
        if(StringUtils.isNotNull(list)){
            for (Customize1 m:list) {
                JSONObject item = new JSONObject();
                item.put("value", m.getCustomize1());
                item.put("label", m.getCustomize1());
                dataArray.add(item);
            }
        }
        return AjaxResult.success(dataArray);
    }
}
