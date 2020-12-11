package com.shengqu.dl.http;

import com.shengqu.dl.http.request.IRequest;

import java.util.Map;

public class LfHttpTask {

    protected Object execute(IRequest request, Map<String, Object> params){
        return HttpHelper.execute(request, params);
    }
}
