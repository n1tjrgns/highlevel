package com.spring.highlevel.trace.strategy;

import com.spring.highlevel.trace.strategy.code.ContextV2;
import com.spring.highlevel.trace.strategy.code.StrateLogic1;
import com.spring.highlevel.trace.strategy.code.StrateLogic2;
import com.spring.highlevel.trace.strategy.code.Strategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void 전략패턴_파라미터로_전달() { //컨텍스트를 실행하는 시점에 원하는 strategy를 전달 할 수 있는 장점이 있음.
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new StrateLogic1());
        contextV2.execute(new StrateLogic2());
    }

    @Test
    void 전략패턴_파라미터로_전달_마찬가지로_익명내부클래스로_사용_가능() {
        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(()->log.info("전략패턴 파라미터 익명 내부 클래스 사용"));
    }
}
