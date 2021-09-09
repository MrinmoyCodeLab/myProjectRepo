package com.example.RibbonConsumerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;

public class RibbonConfig {
	
	@Autowired
    IClientConfig ribbonClientConfig;
 
    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl();
    }
 
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new WeightedResponseTimeRule();
    }
}
