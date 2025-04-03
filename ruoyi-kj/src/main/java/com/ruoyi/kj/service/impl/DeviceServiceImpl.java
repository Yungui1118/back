package com.ruoyi.kj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.kj.mapper.DeviceMapperEx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.kj.mapper.DeviceMapper;
import com.ruoyi.kj.domain.Device;
import com.ruoyi.kj.service.IDeviceService;

/**
 * 设备信息Service业务层处理
 *
 * @author weiliang
 * @date 2022-03-10
 */
@Service
public class DeviceServiceImpl implements IDeviceService
{
    @Autowired
    private DeviceMapper deviceMapper;

    @Autowired
    private DeviceMapperEx deviceMapperEx;

    /**
     * 查询设备信息
     *
     * @param deviceId 设备信息主键
     * @return 设备信息
     */
    @Override
    public Device selectDeviceByDeviceId(Long deviceId)
    {
        return deviceMapper.selectDeviceByDeviceId(deviceId);
    }

    @Override
    public Device selectDeviceByDeviceName(String deviceName) {
        return deviceMapperEx.selectDeviceByDeviceName(deviceName);
    }

    /**
     * 查询设备信息列表
     *
     * @param device 设备信息
     * @return 设备信息
     */
    @Override
    public List<Device> selectDeviceList(Device device)
    {
        return deviceMapper.selectDeviceList(device);
    }

    /**
     * 新增设备信息
     *
     * @param device 设备信息
     * @return 结果
     */
    @Override
    public int insertDevice(Device device)
    {
        device.setCreateTime(DateUtils.getNowDate());
        return deviceMapper.insertDevice(device);
    }

    /**
     * 修改设备信息
     *
     * @param device 设备信息
     * @return 结果
     */
    @Override
    public int updateDevice(Device device)
    {
        device.setUpdateTime(DateUtils.getNowDate());
        return deviceMapper.updateDevice(device);
    }

    /**
     * 批量删除设备信息
     *
     * @param deviceIds 需要删除的设备信息主键
     * @return 结果
     */
    @Override
    public int deleteDeviceByDeviceIds(Long[] deviceIds)
    {
        return deviceMapper.deleteDeviceByDeviceIds(deviceIds);
    }

    /**
     * 删除设备信息信息
     *
     * @param deviceId 设备信息主键
     * @return 结果
     */
    @Override
    public int deleteDeviceByDeviceId(Long deviceId)
    {
        return deviceMapper.deleteDeviceByDeviceId(deviceId);
    }
}
