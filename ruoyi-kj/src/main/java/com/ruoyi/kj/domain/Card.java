package com.ruoyi.kj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 卡号信息对象 kj_card
 *
 * @author weiliang
 * @date 2022-02-21
 */
public class Card extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long cardId;

    /** 卡号 */
    @Excel(name = "卡号")
    private String cardNumber;

    /** 车号id */
    private Long carId;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setCardId(Long cardId)
    {
        this.cardId = cardId;
    }

    public Long getCardId()
    {
        return cardId;
    }
    public void setCardNumber(String cardNumber)
    {
        this.cardNumber = cardNumber;
    }

    public String getCardNumber()
    {
        return cardNumber;
    }
    public void setCarId(Long carId)
    {
        this.carId = carId;
    }

    public Long getCarId()
    {
        return carId;
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
            .append("cardId", getCardId())
            .append("cardNumber", getCardNumber())
            .append("carId", getCarId())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }

    @Excel(name = "车号")
    private String carNumber;

    public void setCarNumber(String carNumber)
    {
        this.carNumber = carNumber;
    }

    public String getCarNumber()
    {
        return carNumber;
    }
}
