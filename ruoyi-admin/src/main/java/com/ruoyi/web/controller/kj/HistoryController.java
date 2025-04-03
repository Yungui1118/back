package com.ruoyi.web.controller.kj;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.kj.domain.History;
import com.ruoyi.kj.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zheng yang
 * @date 2023/6/8 9:22
 */
@RestController
@RequestMapping("/kj/history")
public class HistoryController extends BaseController {

    @Autowired
    private IHistoryService historyService;

    @GetMapping("/list")
    public TableDataInfo list(History history) {
        startPage();
        List<History> list = historyService.selectHistoryList(history);
        return getDataTable(list);
    }

}
