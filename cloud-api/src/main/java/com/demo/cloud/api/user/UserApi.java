package com.demo.cloud.api.user;

import com.demo.cloud.api.user.dto.UserDto;

import java.util.List;

public interface UserApi {

    UserDto getUser(Integer id);

    List<UserDto> getUsers(List<Integer> ids);

}


