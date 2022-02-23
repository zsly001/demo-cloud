package com.demo.cloud.api.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Integer id;

    private String name;

    private List<Permission> permissions;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Permission{

        private Integer code;

        private String name;

    }

}
