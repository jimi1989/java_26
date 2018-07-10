package com.kaishengit.entity;

/**
 * @author jinjianghao
 * @date 2018/7/10
 */
public class Student {

    private Integer id;
    private String userName;
    private String address;
    private Integer SchoolId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSchoolId() {
        return SchoolId;
    }

    public void setSchoolId(Integer schoolId) {
        SchoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", SchoolId=" + SchoolId +
                '}';
    }
}
