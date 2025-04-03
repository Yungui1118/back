package com.ruoyi.kj.service;

import java.util.List;
import com.ruoyi.kj.domain.Car;
import com.ruoyi.kj.vo.CarVo;

/**
 * 车辆信息Service接口
 *
 * @author weiliang
 * @date 2022-04-14
 */
public interface ICarService
{
    /**
     * 查询车辆信息
     *
     * @param carId 车辆信息主键
     * @return 车辆信息
     */
    public Car selectCarByCarId(Long carId);

    /**
     * 查询车辆信息列表
     *
     * @param car 车辆信息
     * @return 车辆信息集合
     */
    public List<Car> selectCarList(Car car);

    public List<CarVo> selectCarVoList(Car car);

    /**
     * 新增车辆信息
     *
     * @param car 车辆信息
     * @return 结果
     */
    public int insertCar(Car car);

    /**
     * 修改车辆信息
     *
     * @param car 车辆信息
     * @return 结果
     */
    public int updateCar(Car car);

    /**
     * 批量删除车辆信息
     *
     * @param carIds 需要删除的车辆信息主键集合
     * @return 结果
     */
    public int deleteCarByCarIds(Long[] carIds);

    /**
     * 删除车辆信息信息
     *
     * @param carId 车辆信息主键
     * @return 结果
     */
    public int deleteCarByCarId(Long carId);
}
