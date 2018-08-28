package com.kaishengit.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author jinjianghao
 * @date 2018/8/23
 */
@Configuration
public class RestConfig {

    //自动从注册中心发现服务，并采用轮询的方式进行负载均衡调用
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
