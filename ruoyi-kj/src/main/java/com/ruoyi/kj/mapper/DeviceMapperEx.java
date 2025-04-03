package com.ruoyi.kj.mapper;

import com.ruoyi.kj.domain.Device;

/**
 * @author zheng yang
 * @date 2022/3/12 13:36
 */
public interface DeviceMapperEx {

    public Device selectDeviceByDeviceName(String deviceName);
}
