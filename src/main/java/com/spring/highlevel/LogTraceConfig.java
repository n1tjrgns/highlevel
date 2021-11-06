package com.spring.highlevel;

import com.spring.highlevel.trace.logtrace.FieldLogTrace;
import com.spring.highlevel.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    //빈으로 등록하면 스프링에서 싱글톤으로 관리해주는것을 잊지 말자.
    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }
}
