package com.ruoyi.kj.mapper;

import com.ruoyi.kj.domain.History;

import java.util.List;

/**
 * @author zheng yang
 * @date 2023/6/7 13:17
 */
public interface HistoryMapper {

    int insert(History history);

    List<History> selectList(History history);

}
