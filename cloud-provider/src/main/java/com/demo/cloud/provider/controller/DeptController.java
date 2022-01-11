package com.demo.cloud.provider.controller;

import com.demo.cloud.api.bo.Dept;
import com.demo.cloud.provider.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @GetMapping("/{id}")
    public Dept getDept(@PathVariable("id") Integer id){
        return deptService.getDept(id);
    }

}
