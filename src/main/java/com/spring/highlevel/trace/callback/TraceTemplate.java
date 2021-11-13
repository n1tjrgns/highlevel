package com.spring.highlevel.trace.callback;

import com.spring.highlevel.trace.TraceStatus;
import com.spring.highlevel.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> traceCallback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);

            T result = traceCallback.call() ;

            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
