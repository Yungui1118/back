package com.ruoyi.kj.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车辆信息对象 kj_car
 *
 * @author weiliang
 * @date 2022-04-14
 */
public class Car extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long carId;

    /**
     * 车牌号
     */
    @Excel(name = "车牌号")
    private String carNumber;

    /**
     * 货物id
     */
    //@Excel(name = "货物id")
    private Long materialId;

    /**
     * 发货单位id
     */
    //@Excel(name = "发货单位id")
    private Long shipperId;

    /**
     * 运输单位id
     */
    //@Excel(name = "运输单位id")
    private Long transportId;

    /**
     * 收货单位id
     */
    //@Excel(name = "收货单位id")
    private Long receiverId;

    /**
     * 自定义1
     */
    @Excel(name = "自定义1")
    private String customize1;

    /**
     * 自定义2
     */
    @Excel(name = "自定义2")
    private String customize2;

    /**
     * 自定义3
     */
    @Excel(name = "自定义3")
    private String customize3;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber == null ? null : carNumber.trim();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setShipperId(Long shipperId) {
        this.shipperId = shipperId;
    }

    public Long getShipperId() {
        return shipperId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setCustomize1(String customize1) {
        this.customize1 = customize1;
    }

    public String getCustomize1() {
        return customize1;
    }

    public void setCustomize2(String customize2) {
        this.customize2 = customize2;
    }

    public String getCustomize2() {
        return customize2;
    }

    public void setCustomize3(String customize3) {
        this.customize3 = customize3;
    }

    public String getCustomize3() {
        return customize3;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("carId", getCarId())
                .append("carNumber", getCarNumber())
                .append("materialId", getMaterialId())
                .append("shipperId", getShipperId())
                .append("transportId", getTransportId())
                .append("receiverId", getReceiverId())
                .append("customize1", getCustomize1())
                .append("customize2", getCustomize2())
                .append("customize3", getCustomize3())
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
