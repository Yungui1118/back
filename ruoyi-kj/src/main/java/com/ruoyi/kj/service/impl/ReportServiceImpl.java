package com.ruoyi.kj.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.kj.domain.*;
import com.ruoyi.kj.mapper.ReportMapper;
import com.ruoyi.kj.service.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @program: ruoyi
 * @description:
 * @author: Mr.Wu
 * @create: 2022-04-14 15:09
 **/
@Service
public class ReportServiceImpl implements IReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<Report> selectReportList(Report report) {
        return reportMapper.selectReportList(report);
    }

    @Override
    public JSONArray selectRemarks() {
        JSONArray array = new JSONArray();
        List<Report> reports = reportMapper.selectRemarks().stream().filter(Objects::nonNull).collect(Collectors.toList());
        for (Report re : reports) {
            array.add(re.getRemarks());
        }
        return array;
    }

    @Override
    public JSONArray selectCustomize1() {
        JSONArray array = new JSONArray();
        List<Report> reports = reportMapper.selectCustomize1().stream().filter(Objects::nonNull).collect(Collectors.toList());
        for (Report re : reports) {
            array.add(re.getCustomize1());
        }
        return array;
    }

    @Override
    public JSONArray selectCustomize2() {
        JSONArray array = new JSONArray();
        List<Report> reports = reportMapper.selectCustomize2().stream().filter(Objects::nonNull).collect(Collectors.toList());
        for (Report re : reports) {
            array.add(re.getCustomize2());
        }
        return array;
    }

    @Override
    public JSONArray selectCustomize3() {
        JSONArray array = new JSONArray();
        List<Report> reports = reportMapper.selectCustomize3().stream().filter(Objects::nonNull).collect(Collectors.toList());
        for (Report re : reports) {
            array.add(re.getCustomize3());
        }
        return array;
    }
}
