package com.kaishengit.dao;

/**
 * @author jinjianghao
 * @date 2018/7/13
 */
public class UserDao {

    public UserDao(){
        System.out.println("userDao create ...");
    }

    public void init() {
        System.out.println("init ...");
    }

    public void destroy() {
        System.out.println("destroyed...");
    }

    public void save() {
        System.out.println("save success !");
    }

}
