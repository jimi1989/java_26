package com.kaishengit.erp.controller;

import com.kaishengit.erp.dto.ResponseBean;
import com.kaishengit.erp.entity.Car;
import com.kaishengit.erp.entity.Customer;
import com.kaishengit.erp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String newCarInfo(Car car, Customer customer, Model model) {
        carService.addCarIndo(car, customer);

        model.addAttribute("car", car);
        model.addAttribute("customer", customer);
        return "order/new";
    }

    @GetMapping("/check")
    @ResponseBody
    public ResponseBean checkCarInfo(String licenseNo){
        // 根据车牌号码查询车辆信息
        Car car = carService.findCarInfoWithCustomer(licenseNo);
        if(car != null) {
            return ResponseBean.success(car);
        } else {
            return ResponseBean.error("暂未录入");
        }
    }

}
