package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Named;

/**
 * @author jinjianghao
 * @date 2018/7/16
 */
@Service("userService")
/*@Scope("prototype")
@Lazy*/
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        // int i = 10 / 0;
        userDao.save();
    }

    /*@Resource
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/
}
