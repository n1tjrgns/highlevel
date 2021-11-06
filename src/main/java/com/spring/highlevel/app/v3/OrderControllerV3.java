package com.spring.highlevel.app.v3;

import com.spring.highlevel.trace.TraceStatus;
import com.spring.highlevel.trace.hellotrace.HelloTraceV2;
import com.spring.highlevel.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    //하지만 수정이  필요할 때마다 모든 파라미터나, 인터페이스가 존재하면 인터페이스를 수정해야한다.
    @GetMapping("/v3/request")
    public String request(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem( itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;//예외를 꼭 다시 던져주어야 한다.
        }
    }
}
