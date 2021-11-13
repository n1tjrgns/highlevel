package com.spring.highlevel.trace.template;

import com.spring.highlevel.trace.template.code.AbstractTemplate;
import com.spring.highlevel.trace.template.code.SubClassLogic1;
import com.spring.highlevel.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV0(){
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
    void 템플릿_메소드_패턴_적용() {
        AbstractTemplate template1 = new SubClassLogic1();
        template1.call();

        AbstractTemplate template2 = new SubClassLogic2();
        template2.call();
    }

}
