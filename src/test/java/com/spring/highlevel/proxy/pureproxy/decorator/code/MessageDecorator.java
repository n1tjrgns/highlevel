package com.spring.highlevel.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyEditorSupport;

@Slf4j
public class MessageDecorator implements Component{

    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("messageDecorator execute");

        String result = component.operation();
        String decoResult = "******" + result + "******";
        log.info("messageDecorator adjust 적용 전={}, 적용 후= {}", result, decoResult);
        return decoResult;
    }
}
