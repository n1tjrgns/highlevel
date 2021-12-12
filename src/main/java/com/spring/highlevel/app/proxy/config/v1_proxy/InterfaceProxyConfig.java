package com.spring.highlevel.app.proxy.config.v1_proxy;

import com.spring.highlevel.app.proxy.config.v1_proxy.interface_proxy.OrderControllerInterfaceProxy;
import com.spring.highlevel.app.proxy.config.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy;
import com.spring.highlevel.app.proxy.config.v1_proxy.interface_proxy.OrderServiceInterfaceProxy;
import com.spring.highlevel.app.proxy.v1.*;
import com.spring.highlevel.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InterfaceProxyConfig {

    @Bean
    public ProxyOrderControllerV1 proxyOrderController(LogTrace logTrace) {
        ProxyOrderControllerV1Impl controllerImpl = new ProxyOrderControllerV1Impl(proxyOrderService(logTrace));
        return new OrderControllerInterfaceProxy(controllerImpl, logTrace);
    }

    @Bean
    public ProxyOrderServiceV1 proxyOrderService(LogTrace logTrace) {
        ProxyOrderServiceV1Impl serviceImpl = new ProxyOrderServiceV1Impl(proxyOrderRepository(logTrace));
        return new OrderServiceInterfaceProxy(serviceImpl, logTrace);
    }

    @Bean
    public ProxyOrderRepositoryV1 proxyOrderRepository(LogTrace logTrace) {
        ProxyOrderRepositoryV1 repositoryImp = new ProxyOrderRepositoryV1Impl();
        return new OrderRepositoryInterfaceProxy(repositoryImp, logTrace);
    }
}
