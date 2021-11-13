 package com.spring.highlevel.app.v4;

import com.spring.highlevel.trace.TraceStatus;
import com.spring.highlevel.trace.logtrace.LogTrace;
import com.spring.highlevel.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save( String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate(trace) {
            @Override
            protected Object call() {
                //저장 로직
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생!");
                }
                sleep(1000);

                return null;
            }
        };

        template.execute("OrderRepository.save()");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
