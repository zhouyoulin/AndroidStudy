package com.shengqu.dl.http;

import com.shengqu.dl.http.call.ICall;
import com.shengqu.dl.http.request.IRequest;

public abstract class HttpScheduler {
    public abstract ICall newCall(IRequest request);

    public Object execute(ICall iCall) {
        return iCall.execute();
    }
}
