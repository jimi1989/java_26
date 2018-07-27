package com.kaishengit.erp.dto;

/**
 * @author jinjianghao
 * @date 2018/7/27
 */
public class ResponseBean {

    private static final String RESPONSEBEAN_STATE_SUCCESS = "success";
    private static final String RESPONSEBEAN_STATE_ERROR = "error";

    private String state;
    private Object data;
    private String message;


    public static ResponseBean success() {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setState(RESPONSEBEAN_STATE_SUCCESS);
        return responseBean;
    }

    public static ResponseBean success(Object obj) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setState(RESPONSEBEAN_STATE_SUCCESS);
        responseBean.setData(obj);
        return responseBean;
    }

    public static ResponseBean error(String message) {
        ResponseBean responseBean = new ResponseBean();
        responseBean.setState(RESPONSEBEAN_STATE_ERROR);
        responseBean.setMessage(message);
        return responseBean;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
