package com.ruoyi.kj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kj.mapper.SequenceMapper;
import com.ruoyi.kj.domain.Sequence;
import com.ruoyi.kj.service.ISequenceService;

/**
 * 单据编号Service业务层处理
 * 
 * @author weiliang
 * @date 2022-02-21
 */
@Service
public class SequenceServiceImpl implements ISequenceService 
{
    @Autowired
    private SequenceMapper sequenceMapper;

    /**
     * 查询单据编号
     * 
     * @param seqName 单据编号主键
     * @return 单据编号
     */
    @Override
    public Sequence selectSequenceBySeqName(String seqName)
    {
        return sequenceMapper.selectSequenceBySeqName(seqName);
    }

    /**
     * 查询单据编号列表
     * 
     * @param sequence 单据编号
     * @return 单据编号
     */
    @Override
    public List<Sequence> selectSequenceList(Sequence sequence)
    {
        return sequenceMapper.selectSequenceList(sequence);
    }

    /**
     * 新增单据编号
     * 
     * @param sequence 单据编号
     * @return 结果
     */
    @Override
    public int insertSequence(Sequence sequence)
    {
        return sequenceMapper.insertSequence(sequence);
    }

    /**
     * 修改单据编号
     * 
     * @param sequence 单据编号
     * @return 结果
     */
    @Override
    public int updateSequence(Sequence sequence)
    {
        return sequenceMapper.updateSequence(sequence);
    }

    /**
     * 批量删除单据编号
     * 
     * @param seqNames 需要删除的单据编号主键
     * @return 结果
     */
    @Override
    public int deleteSequenceBySeqNames(String[] seqNames)
    {
        return sequenceMapper.deleteSequenceBySeqNames(seqNames);
    }

    /**
     * 删除单据编号信息
     * 
     * @param seqName 单据编号主键
     * @return 结果
     */
    @Override
    public int deleteSequenceBySeqName(String seqName)
    {
        return sequenceMapper.deleteSequenceBySeqName(seqName);
    }
}
