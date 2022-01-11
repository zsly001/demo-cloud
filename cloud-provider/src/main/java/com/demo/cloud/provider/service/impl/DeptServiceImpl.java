package com.demo.cloud.provider.service.impl;

import com.demo.cloud.api.bo.Dept;
import com.demo.cloud.provider.service.DeptService;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {

    @Override
    public Dept getDept(Integer id) {
        return new Dept(id,"hello");
    }
}
