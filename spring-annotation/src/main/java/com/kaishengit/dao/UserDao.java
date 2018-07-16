package com.kaishengit.dao;

import org.springframework.stereotype.Repository;

/**
 * @author jinjianghao
 * @date 2018/7/16
 */
@Repository("userDao")
public class UserDao {

    public void save() {
        System.out.println("user save success!");
    }

}
