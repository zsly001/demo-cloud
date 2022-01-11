package com.demo.cloud.consumer.controller;

import com.demo.cloud.api.bo.Dept;
import javafx.scene.DepthTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class RequestController {

    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/dept")
    public Dept getDept(){
        Dept dept = restTemplate.getForObject("http://127.0.0.1:8000/api/dept/123", Dept.class);
        return dept;
    }




}
