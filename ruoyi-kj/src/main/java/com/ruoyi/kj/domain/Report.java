package com.ruoyi.kj.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * @program: ruoyi
 * @description:
 * @author: Mr.Wu
 * @create: 2022-04-14 15:01
 **/

public class Report extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 车号 */
    @Excel(name = "车号")
    private String carnumber;

    /** 发货单位 */
    @Excel(name = "发货单位")
    private String shipper;

    /** 收货单位 */
    @Excel(name = "收货单位")
    private String receiver;

    /** 运输单位 */
    @Excel(name = "运输单位")
    private String transport;

    /** 货名 */
    @Excel(name = "货名")
    private String goods;

//    /** 规格 */
//    @Excel(name = "规格")
//    private String spec;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 自定义1 */
    @Excel(name = "自定义1")
    private String customize1;

    /** 自定义2 */
    @Excel(name = "自定义2")
    private String customize2;

    /** 自定义3 */
    @Excel(name = "自定义3")
    private String customize3;

    /** 毛重司磅员 */
    @Excel(name = "一次司磅员")
    private String createby;

    /** 皮重司磅员 */
    @Excel(name = "二次司磅员")
    private String updateby;

    /** 毛重 */
    @Excel(name = "一次过磅重量")
    private String firstweight;

    /** 皮重 */
    @Excel(name = "二次过磅重量")
    private String secondweight;

    /** 净重 */
    @Excel(name = "净重重量")
    private String netweight;

    /** 车数 */
    @Excel(name = "车数")
    private String carnum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCarnumber() {
        return carnumber;
    }

    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCustomize1() {
        return customize1;
    }

    public void setCustomize1(String customize1) {
        this.customize1 = customize1;
    }

    public String getCustomize2() {
        return customize2;
    }

    public void setCustomize2(String customize2) {
        this.customize2 = customize2;
    }

    public String getCustomize3() {
        return customize3;
    }

    public void setCustomize3(String customize3) {
        this.customize3 = customize3;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public String getFirstweight() {
        return firstweight;
    }

    public void setFirstweight(String firstweight) {
        this.firstweight = firstweight;
    }

    public String getSecondweight() {
        return secondweight;
    }

    public void setSecondweight(String secondweight) {
        this.secondweight = secondweight;
    }

    public String getNetweight() {
        return netweight;
    }

    public void setNetweight(String netweight) {
        this.netweight = netweight;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    @Override
    public String toString() {
        return "Report{" +
                "carnumber='" + carnumber + '\'' +
                ", shipper='" + shipper + '\'' +
                ", receiver='" + receiver + '\'' +
                ", transport='" + transport + '\'' +
                ", goods='" + goods + '\'' +
                ", remarks='" + remarks + '\'' +
                ", customize1='" + customize1 + '\'' +
                ", customize2='" + customize2 + '\'' +
                ", customize3='" + customize3 + '\'' +
                ", createby='" + createby + '\'' +
                ", updateby='" + updateby + '\'' +
                ", firstweight='" + firstweight + '\'' +
                ", secondweight='" + secondweight + '\'' +
                ", netweight='" + netweight + '\'' +
                ", carnum='" + carnum + '\'' +
                '}';
    }
}
