package com.spring.highlevel.app.v4;

import com.spring.highlevel.trace.TraceStatus;
import com.spring.highlevel.trace.logtrace.LogTrace;
import com.spring.highlevel.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    //하지만 수정이  필요할 때마다 모든 파라미터나, 인터페이스가 존재하면 인터페이스를 수정해야한다.
    @GetMapping("/v4/request")
    public String request(String itemId) {

        AbstractTemplate<String> template = new AbstractTemplate(trace) {
            @Override
            protected Object call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };

        return template.execute("OrderController.request()");
    }
}
