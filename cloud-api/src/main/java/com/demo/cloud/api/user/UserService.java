package com.demo.cloud.api.user;

import com.demo.cloud.api.user.dto.UserDto;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface UserService {

    @Headers({"Content-Type:application/json"})
    @RequestLine("GET /user/{id}")
    UserDto getUser(@Param("id") Integer id);

    @RequestLine(("GET /user/list"))
    List<UserDto> getUsers(List<Integer> ids);
}
