package com.spring.highlevel.trace.strategy;

import com.spring.highlevel.trace.strategy.code.ContextV1;
import com.spring.highlevel.trace.strategy.code.StrateLogic1;
import com.spring.highlevel.trace.strategy.code.StrateLogic2;
import com.spring.highlevel.trace.strategy.code.Strategy;
import com.spring.highlevel.trace.template.code.AbstractTemplate;
import com.spring.highlevel.trace.template.code.SubClassLogic1;
import com.spring.highlevel.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyV0(){
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직1 시작");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime : {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        log.info("비즈니스 로직2 시작");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("resultTime : {}", resultTime);
    }

    @Test
    void 전략패턴적용() {
        Strategy strategy = new StrateLogic1();
        ContextV1 contextV1 = new ContextV1(strategy);
        contextV1.execute();

        Strategy strategy2 = new StrateLogic2();
        ContextV1 contextV2 = new ContextV1(strategy2);
        contextV2.execute();
    }
}
