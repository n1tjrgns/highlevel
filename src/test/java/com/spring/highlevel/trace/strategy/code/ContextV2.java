package com.spring.highlevel.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

/*
*   파라미터로 전달 받는 방식
* */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime : {}", resultTime);
    }
}
