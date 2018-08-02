package com.kaishengit.erp.service.impl;

import com.kaishengit.erp.entity.Car;
import com.kaishengit.erp.entity.Customer;
import com.kaishengit.erp.entity.CustomerExample;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.mapper.CarMapper;
import com.kaishengit.erp.mapper.CustomerMapper;
import com.kaishengit.erp.service.CarService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jinjianghao
 * @date 2018/8/2
 */
@Service
public class CarServiceImpl implements CarService {

    private Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CarMapper carMapper;

    /**
     * 添加车辆信息
     *
     * @param car
     * @param customer
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void addCarIndo(Car car, Customer customer) {

        // 通过身份证号码查询客户是否存在
        CustomerExample customerExample = new CustomerExample();
        customerExample.createCriteria().andIdCardEqualTo(customer.getIdCard());
        List<Customer> customerList = customerMapper.selectByExample(customerExample);

        Integer customerId = null;
        // 如果客户不存在则添加客户信息，获得自动生成的主键
        if(customerList == null || customerList.size() == 0) {
            customerMapper.insertSelective(customer);
            customerId = customer.getId();
        }else {
            customerId = customerList.get(0).getId();
        }
        // 校验车辆是否存在
        // 不存在则添加车辆信息
        car.setCustomerId(customerId);
        carMapper.insertSelective(car);

        logger.info("添加车辆信息：{}", car);
    }

    /**
     * 通过车牌号码查找车辆附带车主信息
     * @param licenseNo
     * @return car
     */
    @Override
    public Car findCarInfoWithCustomer(String licenseNo) {
        if(StringUtils.isEmpty(licenseNo)) {
            throw new ServiceException("参数异常");
        }

        Car car = carMapper.findWithCustomerByLicenseNo(licenseNo);
        return car;
    }
}
