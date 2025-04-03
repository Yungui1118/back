package com.ruoyi.kj.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @author zheng yang
 * @date 2022/2/21 0:32
 */
public interface SequenceMapperEx {

    void updateBuildOnlyNumber(@Param("seq_name") String seqName);

    /**
     * 获得一个全局唯一的数作为订单号的追加
     * */
    Long getBuildOnlyNumber(@Param("seq_name") String seqName);

    String getSeqPrefix(@Param("seq_name") String seqName);

}
