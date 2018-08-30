package com.kaishengit.tms.fileStore;

import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.auth.COSSigner;
import com.qcloud.cos.http.HttpMethodName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 腾讯ocs对象存储
 * @author jinjianghao
 * @date 2018/8/29
 */
//@Component
public class TencentCos {

    @Value("${cos.bucketName}")
    private String bucketName;
    @Value("${cos.appId}")
    private String appId;
    @Value("${cos.secretId}")
    private String secretId;
    @Value("${cos.secretKey}")
    private String secretKey;
    @Value("${cos.expireTime}")
    private Integer expireTime;


    /**
     * @param key 要签名的 key, 生成的签名只能用于对应此 key 的上传
     * @return sign 文件上传签名
     */
    public String getCosSign(String key) {
        // bucket 的命名规则为{name}-{appid}
        bucketName = bucketName + "-" + appId;
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        COSSigner signer = new COSSigner();
        //设置过期时间为 1 个小时
        Date expiredTime = new Date(System.currentTimeMillis() + expireTime * 1000L);
        String sign = signer.buildAuthorizationStr(HttpMethodName.PUT, key, cred, expiredTime);
        return sign;
    }

}
