package com.spring.highlevel.proxy.pureproxy.concreateproxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {

    public String operation() {
        log.info("concreateLogic Execute");
        return "data";
    }
}
