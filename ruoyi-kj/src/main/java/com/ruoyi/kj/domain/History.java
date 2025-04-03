package com.ruoyi.kj.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class History extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long historyId;

    private Long weightId;

    private String originalContent;

    private String afterContent;

    private String weightSeq;

    private String carNumber;

    private String materialName;

    private String shipper;

    private String receiver;

    private String transport;

    private BigDecimal firstWeight;

    private BigDecimal secondWeight;

    private BigDecimal netWeight;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date grossTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tareTime;

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Long getWeightId() {
        return weightId;
    }

    public void setWeightId(Long weightId) {
        this.weightId = weightId;
    }

    public String getOriginalContent() {
        return originalContent;
    }

    public void setOriginalContent(String originalContent) {
        this.originalContent = originalContent == null ? null : originalContent.trim();
    }

    public String getAfterContent() {
        return afterContent;
    }

    public void setAfterContent(String afterContent) {
        this.afterContent = afterContent == null ? null : afterContent.trim();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
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

    public Date getGrossTime() {
        return grossTime;
    }

    public void setGrossTime(Date grossTime) {
        this.grossTime = grossTime;
    }

    public Date getTareTime() {
        return tareTime;
    }

    public void setTareTime(Date tareTime) {
        this.tareTime = tareTime;
    }

    public String getWeightSeq() {
        return weightSeq;
    }

    public void setWeightSeq(String weightSeq) {
        this.weightSeq = weightSeq;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public BigDecimal getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(BigDecimal firstWeight) {
        this.firstWeight = firstWeight;
    }

    public BigDecimal getSecondWeight() {
        return secondWeight;
    }

    public void setSecondWeight(BigDecimal secondWeight) {
        this.secondWeight = secondWeight;
    }

    public BigDecimal getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(BigDecimal netWeight) {
        this.netWeight = netWeight;
    }
}