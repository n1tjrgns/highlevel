package com.spring.highlevel.app.proxy.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProxyOrderControllerV3 {

    private final ProxyOrderServiceV3 proxyOrderServiceV3;

    public ProxyOrderControllerV3(ProxyOrderServiceV3 proxyOrderServiceV3) {
        this.proxyOrderServiceV3 = proxyOrderServiceV3;
    }

    @GetMapping("/v3/proxyrequest")
    String request(@RequestParam("itemId") String itemId){
        proxyOrderServiceV3.orderItem(itemId);
        return "ok";
    }

    @GetMapping("/v3/no-log")
    String noLog() {
        return "ok";
    }
}
