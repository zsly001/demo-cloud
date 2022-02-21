package com.demo.cloud.consul.app2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class IndexController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/servers")
    public String getServers(){
        List<String> services = discoveryClient.getServices();
        return Arrays.toString(services.toArray());
    }

    @GetMapping("/hello")
    public String hello(){
        ResponseEntity<String> resp = restTemplate.getForEntity("http://sb-app/hello", String.class);
        return "resp is "+resp;
    }

}
