package com.spring.highlevel.app.v5;

import com.spring.highlevel.trace.callback.TraceTemplate;
import com.spring.highlevel.trace.logtrace.LogTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    //traceTemplate을 빈으로 등록해서 의존성 주입을 받아 사용해도 됨.
    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    //하지만 수정이  필요할 때마다 모든 파라미터나, 인터페이스가 존재하면 인터페이스를 수정해야한다.
    @GetMapping("/v5/request")
    public String request(String itemId) {

        return template.execute("OrderController.request()", ()->{
            orderService.orderItem(itemId);
            return "ok";
        });
    }
}
