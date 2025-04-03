package com.ruoyi.kj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 区域信息对象 kj_customize1
 * 
 * @author weiliang
 * @date 2022-11-18
 */
public class Customize1 extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long customize1Id;

    /** 区域 */
    @Excel(name = "区域")
    private String customize1;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setCustomize1Id(Long customize1Id) 
    {
        this.customize1Id = customize1Id;
    }

    public Long getCustomize1Id() 
    {
        return customize1Id;
    }
    public void setCustomize1(String customize1) 
    {
        this.customize1 = customize1;
    }

    public String getCustomize1() 
    {
        return customize1;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("customize1Id", getCustomize1Id())
            .append("customize1", getCustomize1())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
