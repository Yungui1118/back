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
import com.ruoyi.kj.domain.Car;
import com.ruoyi.kj.service.ICarService;
import com.ruoyi.kj.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 车辆信息Controller
 *
 * @author weiliang
 * @date 2022-04-14
 */
@RestController
@RequestMapping("/kj/car")
public class CarController extends BaseController
{
    @Autowired
    private ICarService carService;

    /**
     * 查询车辆信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:car:list')")
    @GetMapping("/list")
    public TableDataInfo list(Car car)
    {
        startPage();
        List<CarVo> list = carService.selectCarVoList(car);
        return getDataTable(list);
    }

    /**
     * 导出车辆信息列表
     */
    @PreAuthorize("@ss.hasPermi('kj:car:export')")
    @Log(title = "车辆信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Car car)
    {
        //List<Car> list = carService.selectCarList(car);
        List<CarVo> list = carService.selectCarVoList(car);
        ExcelUtil<CarVo> util = new ExcelUtil<CarVo>(CarVo.class);
        util.exportExcel(response, list, "车辆信息数据");
    }

    /**
     * 获取车辆信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('kj:car:query')")
    @GetMapping(value = "/{carId}")
    public AjaxResult getInfo(@PathVariable("carId") Long carId)
    {
        return AjaxResult.success(carService.selectCarByCarId(carId));
    }

    /**
     * 新增车辆信息
     */
    @PreAuthorize("@ss.hasPermi('kj:car:add')")
    @Log(title = "车辆信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Car car)
    {
        return toAjax(carService.insertCar(car));
    }

    /**
     * 修改车辆信息
     */
    @PreAuthorize("@ss.hasPermi('kj:car:edit')")
    @Log(title = "车辆信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Car car)
    {
        return toAjax(carService.updateCar(car));
    }

    /**
     * 删除车辆信息
     */
    @PreAuthorize("@ss.hasPermi('kj:car:remove')")
    @Log(title = "车辆信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{carIds}")
    public AjaxResult remove(@PathVariable Long[] carIds)
    {
        return toAjax(carService.deleteCarByCarIds(carIds));
    }

    /**
     * 查询车辆信息下拉选项
     */
    @PreAuthorize("@ss.hasPermi('kj:car:query')")
    @GetMapping("/getOptions")
    public AjaxResult getOptions()
    {
        JSONArray dataArray = new JSONArray();
        List<Car> list = carService.selectCarList(new Car());
        if(StringUtils.isNotNull(list)){
            for (Car cr:list) {
                JSONObject item = new JSONObject();
                item.put("value", cr.getCarId());
                item.put("label", cr.getCarNumber());
                dataArray.add(item);
            }
        }
        return AjaxResult.success(dataArray);
    }
}
