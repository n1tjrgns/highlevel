package com.spring.highlevel.app.proxy.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping// 스프링은 @Controller or @RequestMapping이 있어야 스프링 컨트롤러로 인식함.
@ResponseBody
public interface ProxyOrderControllerV1 {

    @GetMapping("/v1/proxyrequest")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();
}
