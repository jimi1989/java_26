package com.kaishengit.service.impl;

import com.kaishengit.service.UserService;

/**
 * @author jinjianghao
 * @date 2018/8/11
 */

public class UserServiceImpl implements UserService {

    public String findById(Integer id) {
        if(id.equals(1001)) {
            return "jack,hanks";
        } else {
            return "rose";
        }

    }
}
