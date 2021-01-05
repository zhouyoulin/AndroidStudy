package com.shengqu.dl.http.okhttp;

import com.shengqu.dl.http.HttpScheduler;
import com.shengqu.dl.http.annotation.RequestMethod;
import com.shengqu.dl.http.call.ICall;
import com.shengqu.dl.http.request.IRequest;

import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpScheduler extends HttpScheduler {

    private OkHttpClient client;

    @Override
    public ICall newCall(IRequest request) {
        Map<String, Object> params = request.getParams();
        int requestMethod = request.getRequestMethod();
        Request.Builder requestBuilder = new Request.Builder();
        switch (requestMethod){
            case RequestMethod.GET:
                StringBuilder urlStringBuilder = new StringBuilder(request.getHost().getHost());
                urlStringBuilder.append(request.getPath());
                HttpUrl.Builder urlBuilder = HttpUrl.parse(urlStringBuilder.toString()).newBuilder();
                if (params != null && params.size()>0){
                    Iterator<Map.Entry<String, Object>> iterator = params.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<String, Object> next = iterator.next();
                        // TODO 有问题，obj转String
                        urlBuilder.addQueryParameter(next.getKey(), String.valueOf(next.getValue()));
                    }
                }
                requestBuilder.get().url(urlBuilder.build());
                break;
            case RequestMethod.POST:
                break;
        }
        Request okHttpRequest = requestBuilder.build();
        Call call = getClient().newCall(okHttpRequest);
        OkHttpCall okHttpCall = new OkHttpCall(request, call);
        return okHttpCall;
    }

    private OkHttpClient getClient() {
        if (client == null){
            client = new OkHttpClient();
        }
        return client;
    }
}
