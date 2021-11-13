package com.spring.highlevel.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrateLogic1 implements Strategy{
    @Override
    public void call() {
        log.info("전략패턴 비즈니스로직 1");
    }
}
