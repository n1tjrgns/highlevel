package com.spring.highlevel.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/*
*  필드로 전달 받는 방식
* */
@Slf4j
public class ContextV1 {

    private final Strategy strategy;

    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }

    public void execute() {
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime : {}", resultTime);
    }
}
