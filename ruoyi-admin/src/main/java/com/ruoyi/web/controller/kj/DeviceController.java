package com.ruoyi.web.controller.kj;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.kj.domain.Device;
import com.ruoyi.kj.service.IDeviceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 设备信息Controller
 *
 * @author weiliang
 * @date 2022-03-10
 */
@RestController
@RequestMapping("/kj/device")
public class DeviceController extends BaseController
{
    @Autowired
    private IDeviceService deviceService;

    /**
     * 查询设备信息列表
     */
    @ApiOperation(value = "获取设备信息列表")
    @GetMapping("/list")
    public TableDataInfo list(Device device)
    {
        startPage();
        List<Device> list = deviceService.selectDeviceList(device);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, Device device)
    {
        List<Device> list = deviceService.selectDeviceList(device);
        ExcelUtil<Device> util = new ExcelUtil<Device>(Device.class);
        util.exportExcel(response, list, "设备信息数据");
    }

    /**
     * 获取设备信息详细信息
     */
    @GetMapping(value = "/{deviceId}")
    public AjaxResult getInfo(@PathVariable("deviceId") Long deviceId)
    {
        return AjaxResult.success(deviceService.selectDeviceByDeviceId(deviceId));
    }

    /**
     * 获取设备信息详细信息
     */
    @ApiOperation(value = "获取设备信息")
    @GetMapping
    public AjaxResult getInfo(@RequestParam("deviceName") String deviceName)
    {
        return AjaxResult.success(deviceService.selectDeviceByDeviceName(deviceName));
    }

    /**
     * 新增设备信息
     */
    @PostMapping
    public AjaxResult add(@RequestBody Device device)
    {
        return toAjax(deviceService.insertDevice(device));
    }

    /**
     * 修改设备信息
     */
    @PutMapping
    public AjaxResult edit(@RequestBody Device device)
    {
        return toAjax(deviceService.updateDevice(device));
    }

    /**
     * 删除设备信息
     */
	@DeleteMapping("/{deviceIds}")
    public AjaxResult remove(@PathVariable Long[] deviceIds)
    {
        return toAjax(deviceService.deleteDeviceByDeviceIds(deviceIds));
    }

    /**
     * 查询设备信息下拉选项
     */
    @GetMapping("/getOptions")
    @ApiOperation(value = "获取设备下拉选择列表")
    public AjaxResult getOptions()
    {
        JSONArray dataArray = new JSONArray();
        List<Device> list = deviceService.selectDeviceList(new Device());
        if(StringUtils.isNotNull(list)){
            for (Device dv:list) {
                JSONObject item = new JSONObject();
                item.put("value", dv.getDeviceId());
                item.put("label", dv.getDeviceName());
                dataArray.add(item);
            }
        }
        return AjaxResult.success(dataArray);
    }
}
