package com.demo.cloud.consul.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HealthCheckController {

    @GetMapping("/check/health")
    public String health(){
        System.out.println("check at "+new Date());
        return "success";
    }

}
