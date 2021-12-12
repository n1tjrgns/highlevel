package com.spring.highlevel.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeDecorator implements Component{

    private Component component;

    public TimeDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("TimeDecorator execute");
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();

        String result = component.operation();

        long resultTime = end - start;

        log.info("TimeDecorator end = {}", resultTime);
        return result;
    }
}
