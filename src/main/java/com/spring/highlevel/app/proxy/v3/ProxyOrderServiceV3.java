package com.spring.highlevel.app.proxy.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProxyOrderServiceV3 {

    private final ProxyOrderRepositoryV3 proxyOrderRepositoryV3;

    public ProxyOrderServiceV3(ProxyOrderRepositoryV3 proxyOrderRepositoryV3) {
        this.proxyOrderRepositoryV3 = proxyOrderRepositoryV3;
    }


    public void orderItem(String itemId) {
        proxyOrderRepositoryV3.save(itemId);
    }
}
