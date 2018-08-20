package com.kaishengit.erp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jinjianghao
 * @date 2018/8/20
 */
@Component
public class Jdbc {
    @Value("jdbc.url")
    private String url;
    @Value("jdbc.username")
    private String userName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
