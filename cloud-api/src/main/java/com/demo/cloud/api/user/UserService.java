package com.demo.cloud.api.user;

import com.demo.cloud.api.user.dto.UserDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface UserService {

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @RequestLine("GET /user/{id}")
    UserDto getUser(@Param("id") Integer id);

    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @RequestLine(("GET /user/list?id={id}"))
    List<UserDto> getUsers(@Param("id") List<Integer> ids);





}
