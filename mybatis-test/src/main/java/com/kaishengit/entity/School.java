package com.kaishengit.entity;

import java.io.Serializable;

/**
 * @author jinjianghao
 * @date 2018/7/10
 */
public class School implements Serializable {

    private Integer id;
    private String schoolName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", schoolName='" + schoolName + '\'' +
                '}';
    }
}
