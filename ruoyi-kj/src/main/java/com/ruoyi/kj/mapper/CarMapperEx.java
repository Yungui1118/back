package com.ruoyi.kj.mapper;

import com.ruoyi.kj.domain.Car;
import com.ruoyi.kj.vo.CarVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zheng yang
 * @date 2022/4/14 11:40
 */
public interface CarMapperEx {

    public CarVo selectCarVoListByCarNumber(@Param("carNumber") String carNumber);

    public List<CarVo> selectCarVoList(Car car);

}
