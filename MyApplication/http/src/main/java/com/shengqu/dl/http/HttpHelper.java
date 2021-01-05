package com.shengqu.dl.http;

import com.shengqu.dl.http.call.ICall;
import com.shengqu.dl.http.okhttp.OkHttpScheduler;
import com.shengqu.dl.http.request.IRequest;

import java.util.Map;

public class HttpHelper {

    private volatile static HttpScheduler httpScheduler;

    public static  HttpScheduler getHttpScheduler(){
        if (httpScheduler == null){
            synchronized (HttpHelper.class){
                if (httpScheduler == null){
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }

    // TODO
    protected static Object execute(IRequest request, Map<String, Object> params){
        request.setParams(params);
        ICall iCall = getHttpScheduler().newCall(request);
        Object object = getHttpScheduler().execute(iCall);
        return object;
    }
}
