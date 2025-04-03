package com.ruoyi.kj.service;

import java.util.List;
import com.ruoyi.kj.domain.Sequence;

/**
 * 单据编号Service接口
 * 
 * @author weiliang
 * @date 2022-02-21
 */
public interface ISequenceService 
{
    /**
     * 查询单据编号
     * 
     * @param seqName 单据编号主键
     * @return 单据编号
     */
    public Sequence selectSequenceBySeqName(String seqName);

    /**
     * 查询单据编号列表
     * 
     * @param sequence 单据编号
     * @return 单据编号集合
     */
    public List<Sequence> selectSequenceList(Sequence sequence);

    /**
     * 新增单据编号
     * 
     * @param sequence 单据编号
     * @return 结果
     */
    public int insertSequence(Sequence sequence);

    /**
     * 修改单据编号
     * 
     * @param sequence 单据编号
     * @return 结果
     */
    public int updateSequence(Sequence sequence);

    /**
     * 批量删除单据编号
     * 
     * @param seqNames 需要删除的单据编号主键集合
     * @return 结果
     */
    public int deleteSequenceBySeqNames(String[] seqNames);

    /**
     * 删除单据编号信息
     * 
     * @param seqName 单据编号主键
     * @return 结果
     */
    public int deleteSequenceBySeqName(String seqName);
}
