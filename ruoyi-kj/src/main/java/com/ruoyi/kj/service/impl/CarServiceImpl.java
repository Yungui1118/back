package com.ruoyi.kj.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.kj.domain.Car;
import com.ruoyi.kj.mapper.CarMapper;
import com.ruoyi.kj.mapper.CarMapperEx;
import com.ruoyi.kj.service.ICarService;
import com.ruoyi.kj.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 车辆信息Service业务层处理
 *
 * @author weiliang
 * @date 2022-04-14
 */
@Service
public class CarServiceImpl implements ICarService
{
    @Autowired
    private CarMapper carMapper;

    @Autowired
    private CarMapperEx carMapperEx;

    /**
     * 查询车辆信息
     *
     * @param carId 车辆信息主键
     * @return 车辆信息
     */
    @Override
    public Car selectCarByCarId(Long carId)
    {
        return carMapper.selectCarByCarId(carId);
    }

    /**
     * 查询车辆信息列表
     *
     * @param car 车辆信息
     * @return 车辆信息
     */
    @Override
    public List<Car> selectCarList(Car car)
    {
        return carMapper.selectCarList(car);
    }

    @Override
    public List<CarVo> selectCarVoList(Car car) {
        return carMapperEx.selectCarVoList(car);
    }

    /**
     * 新增车辆信息
     *
     * @param car 车辆信息
     * @return 结果
     */
    @Override
    public int insertCar(Car car)
    {
        Car carOld = carMapper.selectCarByCarNumber(car.getCarNumber());
        if(carOld != null){
            car.setUpdateTime(DateUtils.getNowDate());
            car.setCarId(carOld.getCarId());
            return carMapper.updateCar(car);
        }
        car.setCreateTime(DateUtils.getNowDate());
        return carMapper.insertCar(car);
    }

    /**
     * 修改车辆信息
     *
     * @param car 车辆信息
     * @return 结果
     */
    @Override
    public int updateCar(Car car)
    {
        car.setUpdateTime(DateUtils.getNowDate());
        return carMapper.updateCar(car);
    }

    /**
     * 批量删除车辆信息
     *
     * @param carIds 需要删除的车辆信息主键
     * @return 结果
     */
    @Override
    public int deleteCarByCarIds(Long[] carIds)
    {
        return carMapper.deleteCarByCarIds(carIds);
    }

    /**
     * 删除车辆信息信息
     *
     * @param carId 车辆信息主键
     * @return 结果
     */
    @Override
    public int deleteCarByCarId(Long carId)
    {
        return carMapper.deleteCarByCarId(carId);
    }
}
