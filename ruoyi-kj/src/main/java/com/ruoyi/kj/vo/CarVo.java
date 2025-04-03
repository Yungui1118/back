package com.ruoyi.kj.vo;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.kj.domain.Car;

/**
 * @author zheng yang
 * @date 2022/4/14 11:37
 */
public class CarVo extends Car {

    /** 货名 */
    @Excel(name = "货物")
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

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
