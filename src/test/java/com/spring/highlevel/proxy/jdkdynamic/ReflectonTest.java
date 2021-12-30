package com.spring.highlevel.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

@Slf4j
public class ReflectonTest {

    @Test
    void reflection0(){
        Hello target = new Hello();

        //공통 로직 1 시작
        log.info("start");
        String result1 = target.callA();
        //공통 로직 1 종료
        log.info("end");

        //공통 로직 2 시작
        log.info("start");
        String result2 = target.callB();
        //공통 로직 2 종료
        log.info("end");

        //동적으로 call을 호출할 수는 없을까??
    }

    @Test
    void reflection2() throws Exception {
        Class<?> className = Class.forName("com.spring.highlevel.proxy.jdkdynamic.ReflectonTest$Hello");

        Hello target = new Hello();
        Method callA = className.getMethod("callA");
        dynamicCall(callA, target);

        Method callB = className.getMethod("callB");
        dynamicCall(callB, target);
    }

    private void dynamicCall(Method method, Hello target) throws Exception{
        log.info("start");
        Object result = method.invoke(target);
        log.info("result={}", result);
    }


    @Slf4j
    static class Hello {
        public String callA() {
            log.info("callA");
            return "A";
        }

        public String callB() {
            log.info("callB");
            return "B";
        }
    }

}
