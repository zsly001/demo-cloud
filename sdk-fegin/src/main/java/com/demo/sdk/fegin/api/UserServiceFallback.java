package com.demo.sdk.fegin.api;

import com.demo.cloud.api.user.UserService;
import com.demo.cloud.api.user.dto.UserDto;
import feign.hystrix.FallbackFactory;

import java.util.List;

public class UserServiceFallback implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public UserDto getUser(Integer id) {
                return new UserDto(-1,"降级",null);
            }

            @Override
            public List<UserDto> getUsers(List<Integer> ids) {
                return null;
            }
        };
    }
}
