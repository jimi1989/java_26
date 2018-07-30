package com.kaishengit.erp.service.impl;

import com.kaishengit.erp.entity.Employee;
import com.kaishengit.erp.entity.EmployeeExample;
import com.kaishengit.erp.entity.EmployeeLoginLog;
import com.kaishengit.erp.entity.EmployeeRole;
import com.kaishengit.erp.exception.ServiceException;
import com.kaishengit.erp.mapper.EmployeeLoginLogMapper;
import com.kaishengit.erp.mapper.EmployeeMapper;
import com.kaishengit.erp.mapper.EmployeeRoleMapper;
import com.kaishengit.erp.service.EmployeeService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author jinjianghao
 * @date 2018/7/26
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeLoginLogMapper employeeLoginLogMapper;

    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;


    /**
     * 员工登录
     *
     * @param userTel  用户手机号码
     * @param password 用户密码
     * @param loginIp  用户的登录ip
     * @return employee对象
     * @throws ServiceException 用户名或者密码错误 状态异常等
     *
     */
    @Override
    public Employee login(String userTel, String password, String loginIp) throws ServiceException{

        // 根据userTel获得对应的employee对象
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmployeeTelEqualTo(userTel);

        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);

        Employee employee = null;
        if(employeeList != null && employeeList.size() > 0) {
            employee = employeeList.get(0);
            // 判断密码是否匹配
            if(employee.getPassword().equals(DigestUtils.md5Hex(password))) {
                // 判断员工状态
                if(employee.getState().equals(Employee.EMPLOYEE_STATE_NORMAL)) {
                    // 记录登录日志
                    EmployeeLoginLog employeeLoginLog = new EmployeeLoginLog();
                    employeeLoginLog.setLoginIp(loginIp);
                    employeeLoginLog.setLoginTime(new Date());
                    employeeLoginLog.setEmployeeId(employee.getId());

                    employeeLoginLogMapper.insertSelective(employeeLoginLog);

                    logger.info("{}-{} 在 {} 登录了系统", employee.getEmployeeName(),employee.getEmployeeTel(),new Date());
                    return employee;
                    // 返回对象
                } else {
                    throw new ServiceException("当前账户状态异常，请联系管理员");
                }
            } else {
                throw new ServiceException("用户名或者密码错误");
            }
        } else {
            throw new ServiceException("用户名或者密码错误");
        }


    }

    /**
     * @param requestParam
     * @return
     */
    @Override
    public List<Employee> findAllAccountWithRolesByQueryParam(Map<String, Object> requestParam) {
        return employeeMapper.findAllWithRolesByQueryParam(requestParam);
    }

    /**
     * 新增员工
     *
     * @param employee
     * @param roleIds
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void saveEmployee(Employee employee, Integer[] roleIds) {
        //对密码进行MD5加密
        String codePassword = DigestUtils.md5Hex(employee.getPassword());
        employee.setPassword(codePassword);

        //账号默认状态
        employee.setState(Employee.EMPLOYEE_STATE_NORMAL);

        //添加账号和角色的对应关系表
        employeeMapper.insertSelective(employee);

        for(Integer roleId : roleIds) {
            EmployeeRole employeeRole = new EmployeeRole();
            employeeRole.setEmployeeId(employee.getId());
            employeeRole.setRoleId(roleId);

            employeeRoleMapper.insertSelective(employeeRole);
        }

        logger.info("新增账号 {}", employee);
    }

    /**
     * 根据id查询账号信息
     *
     * @param id
     * @return
     */
    @Override
    public Employee findEmployeeById(Integer id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据电话号码查询账号对象
     *
     * @param userTel 电话号码
     * @return employee对象
     */
    @Override
    public Employee findEmployeeByTel(String userTel) {
        EmployeeExample employeeExample = new EmployeeExample();
        employeeExample.createCriteria().andEmployeeTelEqualTo(userTel);
        List<Employee> employeeList = employeeMapper.selectByExample(employeeExample);
        if(employeeList != null && employeeList.size() > 0) {
            return employeeList.get(0);
        }
        return null;
    }

    /**
     * 记录登录日志
     * @param employeeLoginLog
     */
    @Override
    public void saveLoginLog(EmployeeLoginLog employeeLoginLog) {
        employeeLoginLogMapper.insertSelective(employeeLoginLog);
    }
}
