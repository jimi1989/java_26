package com.kaishengit.erp.vo;

/**
 * @author jinjianghao
 * @date 2018/8/3
 */
public class PartsVo {

    private Integer id;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "PartsVo{" +
                "id=" + id +
                ", num=" + num +
                '}';
    }
}
