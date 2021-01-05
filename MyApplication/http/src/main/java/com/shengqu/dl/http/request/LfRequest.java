package com.shengqu.dl.http.request;

import com.shengqu.dl.http.annotation.RequestMethod;
import com.shengqu.dl.http.request.host.IHost;

import java.util.Map;

public class LfRequest implements IRequest{

    protected IHost host;

    protected Map<String, Object> params;

    @RequestMethod
    protected int requestMethod;

    protected String path;

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public int getRequestMethod() {
        return requestMethod;
    }

    @Override
    public IHost getHost() {
        return host;
    }

    @Override
    public String getPath() {
        return path;
    }


}
