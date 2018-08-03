package com.kaishengit.erp.service;

import com.kaishengit.erp.entity.Car;
import com.kaishengit.erp.entity.Customer;
import com.kaishengit.erp.entity.ServiceType;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/2
 */
public interface CarService {
    /**
     * 添加车辆信息
     * @param car
     * @param customer
     */
    void addCarIndo(Car car, Customer customer);

    /**
     * 通过车牌号码查找车辆附带车主信息
     * @param licenceNo
     * @return car
     */
    Car findCarInfoWithCustomer(String licenceNo);

}
