package com.spring.highlevel.app.proxy.config.v1_proxy.interface_proxy;

import com.spring.highlevel.app.proxy.v1.ProxyOrderRepositoryV1;
import com.spring.highlevel.trace.TraceStatus;
import com.spring.highlevel.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements ProxyOrderRepositoryV1 {

    private final ProxyOrderRepositoryV1 target;
    private final LogTrace logTrace;
    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.request()");
            //target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }

    }
}
