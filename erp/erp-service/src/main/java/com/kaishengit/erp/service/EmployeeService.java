package com.kaishengit.erp.service;

import com.kaishengit.erp.entity.Employee;
import com.kaishengit.erp.exception.ServiceException;

import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/26
 */
public interface EmployeeService {
    /**
     * 员工登录
     * @param userTel 用户手机号码
     * @param password 用户密码
     * @param loginIp 用户的登录ip
     * @return employee对象
     * @throws ServiceException 用户名或者密码错误 状态异常等
     */
    Employee login(String userTel, String password, String loginIp) throws ServiceException;

    /**
     * 条件筛选所有带角色信息的员工列表
     * @param requestParam
     * @return
     */
    List<Employee> findAllAccountWithRolesByQueryParam(Map<String,Object> requestParam);

    /**
     * 新增员工
     * @param employee
     * @param rolesIds
     */
    void saveEmployee(Employee employee, Integer[] rolesIds);

    /**
     * 根据id查询账号信息
     * @param id
     * @return
     */
    Employee findEmployeeById(Integer id);
}
