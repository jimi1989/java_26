package com.kaishengit.erp.controller;

import com.kaishengit.erp.dto.ResponseBean;
import com.kaishengit.erp.entity.Car;
import com.kaishengit.erp.entity.Customer;
import com.kaishengit.erp.entity.ServiceType;
import com.kaishengit.erp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/2
 */
@RequestMapping("/car")
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/new")
    @ResponseBody
    public ResponseBean newCarInfo(Car car, Customer customer) {
        carService.addCarIndo(car, customer);
        car.setCustomer(customer);
        return ResponseBean.success(car);
    }

    @GetMapping("/check")
    @ResponseBody
    public ResponseBean checkCarInfo(String licenceNo){
        // 根据车牌号码查询车辆信息
        Car car = carService.findCarInfoWithCustomer(licenceNo);
        if(car != null) {
            return ResponseBean.success(car);
        } else {
            return ResponseBean.error("暂未录入");
        }
    }



}
