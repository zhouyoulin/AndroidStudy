package com.shengqu.dl.http.request;

import com.shengqu.dl.http.annotation.RequestMethod;
import com.shengqu.dl.http.request.host.IHost;

public class LfRequest implements IRequest{

    protected IHost host;

    @RequestMethod
    protected int requestMethod;
}
