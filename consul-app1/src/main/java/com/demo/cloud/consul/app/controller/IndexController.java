package com.demo.cloud.consul.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private Environment env;


    @Value("${spring.cloud.consul.discovery.instance-id}")
    private String serviceId;

    @GetMapping("/hello")
    public String hello(){

        return "hello "+env.getProperty("spring.application.name")+" "+serviceId;
    }

}
