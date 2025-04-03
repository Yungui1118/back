package com.ruoyi.web.controller.kj;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.kj.domain.Report;
import com.ruoyi.kj.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: ruoyi
 * @description:
 * @author: Mr.Wu
 * @create: 2022-04-14 15:11
 **/
@RestController
@RequestMapping("/kj/weight")
public class ReportController extends BaseController {
    @Autowired
    private IReportService reportService;

    @PreAuthorize("@ss.hasPermi('kj:weight:list')")
    @GetMapping("/preset")
    public AjaxResult getPresetInfo()
    {
        AjaxResult ajax = AjaxResult.success();
        ajax.put("remarks", reportService.selectRemarks());
        ajax.put("customize1", reportService.selectCustomize1());
        ajax.put("customize2", reportService.selectCustomize2());
        ajax.put("customize3", reportService.selectCustomize3());
        return ajax;
    }

    @PreAuthorize("@ss.hasPermi('kj:weight:list')")
    @GetMapping("/listReport")
    public TableDataInfo listTotal(Report report)
    {
        List<Report> list = reportService.selectReportList(report);
        return getDataTable(list);
    }

    @PreAuthorize("@ss.hasPermi('kj:weight:export')")
    @Log(title = "分类统计称重信息", businessType = BusinessType.EXPORT)
    @PostMapping("/listReportExport")
    public void listExport(HttpServletResponse response, Report report)
    {
        List<Report> list = reportService.selectReportList(report);
        ExcelUtil<Report> util = new ExcelUtil<Report>(Report.class);
        util.exportExcel(response, list, "分类统计称重信息");
    }
}
