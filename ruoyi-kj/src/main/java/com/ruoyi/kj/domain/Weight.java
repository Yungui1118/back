package com.ruoyi.kj.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 称重信息对象 kj_weight
 *
 * @author weiliang
 * @date 2022-04-14
 */
public class Weight extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long weightId;

    /** 称重编号 */
    @Excel(name = "称重编号")
    private String weightSeq;

    /** 车牌号 */
    @Excel(name = "车牌号")
    private String carNumber;

    /** 货名 */
    @Excel(name = "货名")
    private String materialName;

    /** 发货单位 */
    @Excel(name = "发货单位")
    private String shipper;

    /** 运输单位 */
    @Excel(name = "运输单位")
    private String transport;

    /** 收货单位 */
    @Excel(name = "收货单位")
    private String receiver;

    /** 一次称重时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "一次称重时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date firstTime;

    /** 一次过磅图片 */
    // @Excel(name = "一次过磅图片")
    private String firstImg;

    /** 一次过磅重量 */
    @Excel(name = "一次过磅重量",isStatistics = true)
    private BigDecimal firstWeight;

    /** 二次称重时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "二次称重时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date secondTime;

    /** 二次过磅图片 */
    // @Excel(name = "二次过磅图片")
    private String secondImg;

    /** 二次过磅重量 */
    @Excel(name = "二次过磅重量",isStatistics = true)
    private BigDecimal secondWeight;

    /** 净重重量 */
    @Excel(name = "净重重量",isStatistics = true)
    private BigDecimal netWeight;

    /** 自定义1 */
    @Excel(name = "自定义1")
    private String customize1;

    /** 自定义2 */
    @Excel(name = "自定义2")
    private String customize2;

    /** 自定义3 */
    @Excel(name = "自定义3")
    private String customize3;

    /** 称重标识（0未完成 1已完成） */
    // @Excel(name = "称重标识", readConverterExp = "0=未完成,1=已完成")
    private Integer finish;

    /** 上传标识（0未完成 1已完成） */
    // @Excel(name = "上传标识", readConverterExp = "0=未完成,1=已完成")
    private Integer upload;

    /** 状态（0正常 1作废） */
    // @Excel(name = "状态", readConverterExp = "0=正常,1=作废")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setWeightId(Long weightId)
    {
        this.weightId = weightId;
    }

    public Long getWeightId()
    {
        return weightId;
    }
    public void setWeightSeq(String weightSeq)
    {
        this.weightSeq = weightSeq;
    }

    public String getWeightSeq()
    {
        return weightSeq;
    }
    public void setCarNumber(String carNumber)
    {
        this.carNumber = carNumber;
    }

    public String getCarNumber()
    {
        return carNumber;
    }
    public void setMaterialName(String materialName)
    {
        this.materialName = materialName;
    }

    public String getMaterialName()
    {
        return materialName;
    }
    public void setShipper(String shipper)
    {
        this.shipper = shipper;
    }

    public String getShipper()
    {
        return shipper;
    }
    public void setTransport(String transport)
    {
        this.transport = transport;
    }

    public String getTransport()
    {
        return transport;
    }
    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
    }

    public String getReceiver()
    {
        return receiver;
    }
    public void setFirstTime(Date firstTime)
    {
        this.firstTime = firstTime;
    }

    public Date getFirstTime()
    {
        return firstTime;
    }
    public void setFirstImg(String firstImg)
    {
        this.firstImg = firstImg;
    }

    public String getFirstImg()
    {
        return firstImg;
    }
    public void setFirstWeight(BigDecimal firstWeight)
    {
        this.firstWeight = firstWeight;
    }

    public BigDecimal getFirstWeight()
    {
        return firstWeight;
    }
    public void setSecondTime(Date secondTime)
    {
        this.secondTime = secondTime;
    }

    public Date getSecondTime()
    {
        return secondTime;
    }
    public void setSecondImg(String secondImg)
    {
        this.secondImg = secondImg;
    }

    public String getSecondImg()
    {
        return secondImg;
    }
    public void setSecondWeight(BigDecimal secondWeight)
    {
        this.secondWeight = secondWeight;
    }

    public BigDecimal getSecondWeight()
    {
        return secondWeight;
    }
    public void setNetWeight(BigDecimal netWeight)
    {
        this.netWeight = netWeight;
    }

    public BigDecimal getNetWeight()
    {
        return netWeight;
    }
    public void setCustomize1(String customize1)
    {
        this.customize1 = customize1;
    }

    public String getCustomize1()
    {
        return customize1;
    }
    public void setCustomize2(String customize2)
    {
        this.customize2 = customize2;
    }

    public String getCustomize2()
    {
        return customize2;
    }
    public void setCustomize3(String customize3)
    {
        this.customize3 = customize3;
    }

    public String getCustomize3()
    {
        return customize3;
    }
    public void setFinish(Integer finish)
    {
        this.finish = finish;
    }

    public Integer getFinish()
    {
        return finish;
    }
    public void setUpload(Integer upload)
    {
        this.upload = upload;
    }

    public Integer getUpload()
    {
        return upload;
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
            .append("weightId", getWeightId())
            .append("weightSeq", getWeightSeq())
            .append("carNumber", getCarNumber())
            .append("materialName", getMaterialName())
            .append("shipper", getShipper())
            .append("transport", getTransport())
            .append("receiver", getReceiver())
            .append("firstTime", getFirstTime())
            .append("firstImg", getFirstImg())
            .append("firstWeight", getFirstWeight())
            .append("secondTime", getSecondTime())
            .append("secondImg", getSecondImg())
            .append("secondWeight", getSecondWeight())
            .append("netWeight", getNetWeight())
            .append("customize1", getCustomize1())
            .append("customize2", getCustomize2())
            .append("customize3", getCustomize3())
            .append("finish", getFinish())
            .append("upload", getUpload())
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
