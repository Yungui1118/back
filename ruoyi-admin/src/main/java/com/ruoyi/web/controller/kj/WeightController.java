package com.ruoyi.web.controller.kj;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.kj.domain.Weight;
import com.ruoyi.kj.service.IWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * 称重信息Controller
 *
 * @author weiliang
 * @date 2022-04-14
 */
@RestController
@RequestMapping("/kj/weight")
public class WeightController extends BaseController
{
    @Autowired
    private IWeightService weightService;

    /**
     * 查询称重信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:list')")
    @GetMapping("/list")
    public TableDataInfo list(Weight weight)
    {
        startPage();
        List<Weight> list = weightService.selectWeightList(weight);
        return getDataTable(list);
    }

    /**
     * 导出称重信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:export')")
    @Log(title = "称重信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Weight weight)
    {
        List<Weight> list = weightService.selectWeightList(weight);
        ExcelUtil<Weight> util = new ExcelUtil<Weight>(Weight.class);
        util.exportExcel(response, list, "称重信息数据");
    }

    /**
     * 获取称重信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:query')")
    @GetMapping(value = "/{weightId}")
    public AjaxResult getInfo(@PathVariable("weightId") Long weightId)
    {
        return AjaxResult.success(weightService.selectWeightByWeightId(weightId));
    }

    /**
     * 新增称重信息
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:add')")
    @Log(title = "称重信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Weight weight) {
        weight.setUpdateBy(getUsername());
        return weightService.insertWeight(weight);
    }

    /**
     * 新增称重信息
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:add')")
    @Log(title = "手工补单", businessType = BusinessType.ADDMANUAL)
    @PostMapping("/manual")
    public AjaxResult addManual(@RequestBody Weight weight) {
        weight.setUpdateBy(getUsername());
        weight.setCreateBy(getUsername());
        return toAjax(weightService.insertWeightManual(weight));
    }

    /**
     * 修改称重信息
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:edit')")
    @Log(title = "称重信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Weight weight) {
        weight.setUpdateBy(getUsername());
        return toAjax(weightService.updateWeight(weight));
    }

    /**
     * 手动修改称重信息
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:edit')")
    @Log(title = "手工修改", businessType = BusinessType.UPDATEMANUAL)
    @PutMapping("/manual")
    public AjaxResult editManual(@RequestBody Weight weight) {
        weight.setUpdateBy(getUsername());
        return toAjax(weightService.updateWeightManual(weight));
    }

    /**
     * 删除称重信息
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:remove')")
    @Log(title = "称重信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{weightIds}")
    public AjaxResult remove(@PathVariable Long[] weightIds) {
        return toAjax(weightService.deleteWeightByWeightIds(weightIds));
    }

    /**
     * 修改称重视频信息
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:edit')")
    @Log(title = "称重图片", businessType = BusinessType.UPDATE)
    @PostMapping("/pic")
    public AjaxResult editVideo(@RequestBody HashMap<String, String> map)
    {
        Long weightId = Long.valueOf(map.get("weightId"));
        String picPath = map.get("picPath");
        Weight weight = weightService.selectWeightByWeightId(weightId);
        Weight u = new Weight();
        u.setWeightId(weightId);
        if(weight.getFinish() == 0){
            u.setFirstImg(picPath);
        }else {
            u.setSecondImg(picPath);
        }
        return toAjax(weightService.updateWeight(u));
    }

    /**
     * 获取称重视频信息
     */
    @PreAuthorize("@ss.hasPermi('kj:weight:query')")
    @GetMapping(value = "/getVideo/{weightId}")
    public AjaxResult getVideoInfo(@PathVariable("weightId") Long weightId)
    {
        return AjaxResult.success(weightService.selectVideoByWeightId(weightId));
    }

}
