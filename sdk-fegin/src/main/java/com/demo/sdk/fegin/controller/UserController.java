package com.demo.sdk.fegin.controller;

import com.demo.cloud.api.user.UserService;
import com.demo.cloud.api.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {

    @Resource(name = "userApi")
    private UserService userService;


    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable("id") Integer id){
        Objects.requireNonNull(id,"id不能为空");
        //return new UserDto(id,"nnn",new ArrayList<>());
        UserDto user = userService.getUser(id);
        return user;
    }

    @GetMapping("/list")
    public List<UserDto> getUsers(@RequestParam("id") List<Integer> ids){
        Objects.requireNonNull(ids,"ids不能为空");
        return userService.getUsers(ids);
    }

}
