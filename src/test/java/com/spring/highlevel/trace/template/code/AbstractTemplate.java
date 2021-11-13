package com.spring.highlevel.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();

        //log.info("비즈니스 로직1 시작"); 비즈니스 로직을 대체
        call();

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime : {}", resultTime);
    }

    public abstract void call();
}
