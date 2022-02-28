package com.demo.sdk.fegin.config;

import com.demo.cloud.api.user.UserService;
import com.demo.sdk.fegin.api.UserServiceFallback;
import com.demo.sdk.fegin.comp.ConfigLbClientFactory;
import com.netflix.client.ClientFactory;
import com.netflix.client.config.IClientConfig;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.ILoadBalancer;
import feign.*;
import feign.httpclient.ApacheHttpClient;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.LBClient;
import feign.ribbon.LBClientFactory;
import feign.ribbon.LoadBalancingTarget;
import feign.ribbon.RibbonClient;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class ApiConfig {

    @Bean
    public UserService userApi(){

        //ConfigurationManager.loadPropertiesFromResources("");

        /*LoadBalancingTarget<UserService> balancingTarget = LoadBalancingTarget
                .create(UserService.class, "http://10.182.24.107:8501/v1/catalog/service/sb-app");*/

        /*LBClientFactory lbf = new LBClientFactory() {
            @Override
            public LBClient create(String s) {
                IClientConfig config = ClientFactory.getNamedConfig(clientName, LBClientFactory.DisableAutoRetriesByDefaultClientConfig.class);
                ILoadBalancer lb = ClientFactory.getNamedLoadBalancer(clientName);
                return LBClient.create(lb, config);
            }
        };*/

        /*RibbonClient ribbonClient = RibbonClient.builder()
                .delegate(new ApacheHttpClient())
                .lbClientFactory(new ConfigLbClientFactory())
                .build();

        return HystrixFeign.builder()
                .client(ribbonClient)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(UserService.class, "http://consul-server/",new UserServiceFallback());*/

        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .client(new ApacheHttpClient())
                .retryer(Retryer.NEVER_RETRY)
                .logger(new Slf4jLogger())
                .logLevel(Logger.Level.FULL)
                .options(new Request.Options(500, TimeUnit.MILLISECONDS,500,TimeUnit.MILLISECONDS,true))
                .target(UserService.class,"http://10.73.29.111:6061");

    }

}
