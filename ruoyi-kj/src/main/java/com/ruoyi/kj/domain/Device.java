package com.ruoyi.kj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备信息对象 kj_device
 * 
 * @author weiliang
 * @date 2022-03-12
 */
public class Device extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long deviceId;

    /** 设备类型（0网络设备 1串口设备） */
    @Excel(name = "设备类型", readConverterExp = "0=网络设备,1=串口设备")
    private String deviceType;

    /** 设备名 */
    @Excel(name = "设备名")
    private String deviceName;

    /** 自动打开（0是 1否） */
    @Excel(name = "自动打开", readConverterExp = "0=是,1=否")
    private String autoOpen;

    /** IP */
    @Excel(name = "IP")
    private String deviceIp;

    /** 端口 */
    @Excel(name = "端口")
    private String port;

    /** 轮询间隔 */
    @Excel(name = "轮询间隔")
    private String polling;

    /** 自定义 */
    @Excel(name = "自定义")
    private String custom;

    /** 设备账户 */
    @Excel(name = "设备账户")
    private String deviceAcc;

    /** 设备密码 */
    @Excel(name = "设备密码")
    private String devicePas;

    /** 波特率 */
    @Excel(name = "波特率")
    private Long baudRate;

    /** 数据位 */
    @Excel(name = "数据位")
    private Long dataBits;

    /** 奇偶检验 */
    @Excel(name = "奇偶检验")
    private String parity;

    /** 停止位 */
    @Excel(name = "停止位")
    private Long stopBits;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setDeviceId(Long deviceId) 
    {
        this.deviceId = deviceId;
    }

    public Long getDeviceId() 
    {
        return deviceId;
    }
    public void setDeviceType(String deviceType) 
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType() 
    {
        return deviceType;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setAutoOpen(String autoOpen) 
    {
        this.autoOpen = autoOpen;
    }

    public String getAutoOpen() 
    {
        return autoOpen;
    }
    public void setDeviceIp(String deviceIp) 
    {
        this.deviceIp = deviceIp;
    }

    public String getDeviceIp() 
    {
        return deviceIp;
    }
    public void setPort(String port) 
    {
        this.port = port;
    }

    public String getPort() 
    {
        return port;
    }
    public void setPolling(String polling) 
    {
        this.polling = polling;
    }

    public String getPolling() 
    {
        return polling;
    }
    public void setCustom(String custom) 
    {
        this.custom = custom;
    }

    public String getCustom() 
    {
        return custom;
    }
    public void setDeviceAcc(String deviceAcc) 
    {
        this.deviceAcc = deviceAcc;
    }

    public String getDeviceAcc() 
    {
        return deviceAcc;
    }
    public void setDevicePas(String devicePas) 
    {
        this.devicePas = devicePas;
    }

    public String getDevicePas() 
    {
        return devicePas;
    }
    public void setBaudRate(Long baudRate) 
    {
        this.baudRate = baudRate;
    }

    public Long getBaudRate() 
    {
        return baudRate;
    }
    public void setDataBits(Long dataBits) 
    {
        this.dataBits = dataBits;
    }

    public Long getDataBits() 
    {
        return dataBits;
    }
    public void setParity(String parity) 
    {
        this.parity = parity;
    }

    public String getParity() 
    {
        return parity;
    }
    public void setStopBits(Long stopBits) 
    {
        this.stopBits = stopBits;
    }

    public Long getStopBits() 
    {
        return stopBits;
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
            .append("deviceId", getDeviceId())
            .append("deviceType", getDeviceType())
            .append("deviceName", getDeviceName())
            .append("autoOpen", getAutoOpen())
            .append("deviceIp", getDeviceIp())
            .append("port", getPort())
            .append("polling", getPolling())
            .append("custom", getCustom())
            .append("deviceAcc", getDeviceAcc())
            .append("devicePas", getDevicePas())
            .append("baudRate", getBaudRate())
            .append("dataBits", getDataBits())
            .append("parity", getParity())
            .append("stopBits", getStopBits())
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
