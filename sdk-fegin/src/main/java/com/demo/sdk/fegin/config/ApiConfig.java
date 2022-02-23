package com.demo.sdk.fegin.config;

import com.demo.cloud.api.user.UserService;
import com.demo.sdk.fegin.api.UserServiceFallback;
import feign.httpclient.ApacheHttpClient;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {

    @Bean
    public UserService userApi(){

        return HystrixFeign.builder()
                .client(new ApacheHttpClient())
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(UserService.class,"http://127.0.0.1:6060",new UserServiceFallback());

    }

}
