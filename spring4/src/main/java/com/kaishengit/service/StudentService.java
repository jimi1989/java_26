package com.kaishengit.service;

import com.kaishengit.dao.StudentDao;

/**
 * @author jinjianghao
 * @date 2018/7/14
 */
public class StudentService {

    private StudentDao studentDao;

    public StudentService(StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public void save() {
        studentDao.save();
    }

    /*public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }*/
}
