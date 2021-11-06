package com.spring.highlevel.trace.logtrace;

import com.spring.highlevel.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception e);
}
