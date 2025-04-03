package com.ruoyi.kj.service.impl;

import com.ruoyi.kj.domain.History;
import com.ruoyi.kj.mapper.HistoryMapper;
import com.ruoyi.kj.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zheng yang
 * @date 2023/6/8 9:00
 */
@Service
public class HistoryServiceImpl implements IHistoryService {

    @Autowired
    HistoryMapper historyMapper;

    @Override
    public List<History> selectHistoryList(History history) {
        return historyMapper.selectList(history);
    }
}
