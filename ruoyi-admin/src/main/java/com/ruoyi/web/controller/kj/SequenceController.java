package com.ruoyi.web.controller.kj;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.kj.service.ISequenceServiceEx;
import io.swagger.annotations.ApiOperation;
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
import com.ruoyi.kj.domain.Sequence;
import com.ruoyi.kj.service.ISequenceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 单据编号Controller
 *
 * @author weiliang
 * @date 2022-02-21
 */
@RestController
@RequestMapping("/kj/sequence")
public class SequenceController extends BaseController
{
    @Autowired
    private ISequenceService sequenceService;

    @Autowired
    private ISequenceServiceEx sequenceServiceEx;

    /**
     * 查询单据编号列表
     */
    @GetMapping("/list")
    public TableDataInfo list(Sequence sequence)
    {
        startPage();
        List<Sequence> list = sequenceService.selectSequenceList(sequence);
        return getDataTable(list);
    }

    /**
     * 导出单据编号列表
     */
    @Log(title = "单据编号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Sequence sequence)
    {
        List<Sequence> list = sequenceService.selectSequenceList(sequence);
        ExcelUtil<Sequence> util = new ExcelUtil<Sequence>(Sequence.class);
        util.exportExcel(response, list, "单据编号数据");
    }

    /**
     * 获取单据编号详细信息
     */
    @GetMapping(value = "/{seqName}")
    public AjaxResult getInfo(@PathVariable("seqName") String seqName)
    {
        return AjaxResult.success(sequenceService.selectSequenceBySeqName(seqName));
    }

    /**
     * 新增单据编号
     */
    @Log(title = "单据编号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sequence sequence)
    {
        return toAjax(sequenceService.insertSequence(sequence));
    }

    /**
     * 修改单据编号
     */
    @Log(title = "单据编号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sequence sequence)
    {
        return toAjax(sequenceService.updateSequence(sequence));
    }

    /**
     * 删除单据编号
     */
    @Log(title = "单据编号", businessType = BusinessType.DELETE)
	@DeleteMapping("/{seqNames}")
    public AjaxResult remove(@PathVariable String[] seqNames)
    {
        return toAjax(sequenceService.deleteSequenceBySeqNames(seqNames));
    }

    /**
     * 单据编号生成接口
     */
    @GetMapping(value = "/buildNumber/{type}")
    @ApiOperation(value = "单据编号生成接口")
    public AjaxResult buildNumber(@PathVariable String type) {
        return AjaxResult.success(sequenceServiceEx.buildOnlyNumber(type));
    }
}
