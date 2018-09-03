package com.kaishengit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author jinjianghao
 * @date 2018/9/3
 */
@RestController
public class MovieConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/buy/movie/{id:\\d+}")
    public String buyMovie(@PathVariable Integer id) {
        // ServiceInstance封装了服务的ip port等信息
        ServiceInstance instance = loadBalancerClient.choose("MOVIE-SERVICE-PROVIDER");
        System.out.println(instance.getServiceId());
        System.out.println(instance.getUri());
        // String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/movie/" + id;
        String url = instance.getUri() + "/movie/" + id;
        System.out.println(url);
        String movieName = restTemplate.getForObject(url, String.class);
        System.out.println(movieName);
        return movieName;
    }

//    @GetMapping("/buy/movie/{id:\\d+}")
//    public String buyMovie(@PathVariable Integer id) {
//        String url = "http://127.0.0.1:8001/movie/" + id;
//        String movieName = restTemplate.getForObject(url, String.class);
//        System.out.println(movieName);
//        return movieName;
//    }

}
