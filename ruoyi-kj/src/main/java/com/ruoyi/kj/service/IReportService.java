package com.ruoyi.kj.service;

import com.alibaba.fastjson.JSONArray;
import com.ruoyi.kj.domain.*;

import java.util.List;

/**
 * @program: ruoyi
 * @description:
 * @author: Mr.Wu
 * @create: 2022-04-14 15:09
 **/

public interface IReportService {
    public List<Report> selectReportList(Report report);

    public JSONArray selectRemarks();

    public JSONArray selectCustomize1();

    public JSONArray selectCustomize2();

    public JSONArray selectCustomize3();
}
