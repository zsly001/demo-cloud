package com.demo.cloud.consul.app.controller;

import com.demo.cloud.api.user.UserService;
import com.demo.cloud.api.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Integer id){
        Objects.requireNonNull(id,"id不能为空");
        System.out.println("-----"+id);
        return userService.getUser(id);
    }

    @GetMapping("/list")
    public List<UserDto> getUsers(@RequestParam("id") List<Integer> ids){
        Objects.requireNonNull(ids,"ids不能为空");
        return userService.getUsers(ids);
    }

}
