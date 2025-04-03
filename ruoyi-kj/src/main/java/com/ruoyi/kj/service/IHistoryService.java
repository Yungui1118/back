package com.ruoyi.kj.service;

import com.ruoyi.kj.domain.History;

import java.util.List;

/**
 * @author zheng yang
 * @date 2023/6/8 8:59
 */
public interface IHistoryService {

    List<History> selectHistoryList(History history);

}
