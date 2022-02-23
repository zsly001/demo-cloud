package com.demo.cloud.consul.app.service.impl;

import com.demo.cloud.api.user.UserService;
import com.demo.cloud.api.user.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserDto getUser(Integer id) {
        UserDto user = new UserDto();
        user.setId(100);
        user.setName("kkk");
        return user;
    }

    @Override
    public List<UserDto> getUsers(List<Integer> ids) {
        UserDto u1 = new UserDto(10,"aaa", Arrays.asList(new UserDto.Permission(1,"r")));
        UserDto u2 = new UserDto(20,"bbb", Arrays.asList(new UserDto.Permission(1,"w")));
        return Arrays.asList(u1,u2);
    }
}
