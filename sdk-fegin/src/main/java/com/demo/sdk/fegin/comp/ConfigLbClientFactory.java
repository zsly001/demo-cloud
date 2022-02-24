package com.demo.sdk.fegin.comp;

import com.netflix.client.ClientFactory;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.loadbalancer.ILoadBalancer;
import feign.ribbon.LBClient;
import feign.ribbon.LBClientFactory;

public class ConfigLbClientFactory implements LBClientFactory {

    @Override
    public LBClient create(String clientName) {
        DefaultClientConfigImpl config = DefaultClientConfigImpl.getClientConfigWithDefaultValues(clientName,"app");

        ILoadBalancer lb = ClientFactory.getNamedLoadBalancer(clientName);
        return LBClient.create(lb, config);
    }
}
