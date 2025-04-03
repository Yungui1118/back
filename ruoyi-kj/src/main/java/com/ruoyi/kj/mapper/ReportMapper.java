package com.ruoyi.kj.mapper;

import com.ruoyi.kj.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: ruoyi
 * @description:
 * @author: Mr.Wu
 * @create: 2022-04-14 15:05
 **/
public interface ReportMapper {
    //统计报表查询
    public List<Report> selectReportList(Report report);

    public List<Report> selectRemarks();

    public List<Report> selectCustomize1();

    public List<Report> selectCustomize2();

    public List<Report> selectCustomize3();
}
