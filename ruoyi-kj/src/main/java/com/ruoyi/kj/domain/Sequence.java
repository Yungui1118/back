package com.ruoyi.kj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单据编号对象 kj_sequence
 * 
 * @author weiliang
 * @date 2022-02-21
 */
public class Sequence extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序列名称 */
    private String seqName;

    /** 序列前缀 */
    @Excel(name = "序列前缀")
    private String seqPrefix;

    /** 最小值 */
    @Excel(name = "最小值")
    private Long minValue;

    /** 最大值 */
    @Excel(name = "最大值")
    private Long maxValue;

    /** 当前值 */
    @Excel(name = "当前值")
    private Long currentVal;

    /** 增长步数 */
    @Excel(name = "增长步数")
    private Long incrementVal;

    public void setSeqName(String seqName) 
    {
        this.seqName = seqName;
    }

    public String getSeqName() 
    {
        return seqName;
    }
    public void setSeqPrefix(String seqPrefix) 
    {
        this.seqPrefix = seqPrefix;
    }

    public String getSeqPrefix() 
    {
        return seqPrefix;
    }
    public void setMinValue(Long minValue) 
    {
        this.minValue = minValue;
    }

    public Long getMinValue() 
    {
        return minValue;
    }
    public void setMaxValue(Long maxValue) 
    {
        this.maxValue = maxValue;
    }

    public Long getMaxValue() 
    {
        return maxValue;
    }
    public void setCurrentVal(Long currentVal) 
    {
        this.currentVal = currentVal;
    }

    public Long getCurrentVal() 
    {
        return currentVal;
    }
    public void setIncrementVal(Long incrementVal) 
    {
        this.incrementVal = incrementVal;
    }

    public Long getIncrementVal() 
    {
        return incrementVal;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("seqName", getSeqName())
            .append("seqPrefix", getSeqPrefix())
            .append("minValue", getMinValue())
            .append("maxValue", getMaxValue())
            .append("currentVal", getCurrentVal())
            .append("incrementVal", getIncrementVal())
            .append("remark", getRemark())
            .toString();
    }
}
