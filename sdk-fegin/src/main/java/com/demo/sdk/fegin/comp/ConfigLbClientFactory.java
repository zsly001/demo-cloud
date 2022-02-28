package com.demo.sdk.fegin.comp;

import com.netflix.client.ClientFactory;
import com.netflix.client.config.CommonClientConfigKey;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.ILoadBalancer;
import feign.ribbon.LBClient;
import feign.ribbon.LBClientFactory;

public class ConfigLbClientFactory implements LBClientFactory {

    @Override
    public LBClient create(String clientName) {
        //DefaultClientConfigImpl config = DefaultClientConfigImpl.getClientConfigWithDefaultValues(clientName,"app");
        IClientConfig config = ClientFactory.getNamedConfig(clientName);
        config.set(CommonClientConfigKey.ListOfServers,"10.73.29.111:6060,10.73.29.111:6061,10.73.29.111:6062");
        //config.setProperty(CommonClientConfigKey.ListOfServers,"127.0.0.1:6060,127.0.0.1:6061,127.0.0.1:6062");
        ILoadBalancer lb = ClientFactory.getNamedLoadBalancer(clientName);

        /*ILoadBalancer lb = null;
        try {
            lb = ClientFactory.registerNamedLoadBalancerFromclientConfig(clientName,config);
        } catch (ClientException e) {
            throw new RuntimeException("Unable to create load balancer", e);
        }*/
        return LBClient.create(lb, config);
    }
}
