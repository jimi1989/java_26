package com.kaishengit.erp.service;

import com.kaishengit.erp.entity.Car;
import com.kaishengit.erp.entity.Customer;

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
    public void addCarIndo(Car car, Customer customer);

    /**
     * 通过车牌号码查找车辆附带车主信息
     * @param licenseNo
     * @return car
     */
    Car findCarInfoWithCustomer(String licenseNo);
}
