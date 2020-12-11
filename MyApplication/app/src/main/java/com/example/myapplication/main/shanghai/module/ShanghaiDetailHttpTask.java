package com.example.myapplication.main.shanghai.module;

import com.shengqu.dl.http.LfHttpTask;

import java.util.HashMap;
import java.util.Map;

public class ShanghaiDetailHttpTask extends LfHttpTask {

    public Object getXiaohuaList(String sort, String page, String pageSize){
        Map<String, Object> params = new HashMap<>();
        params.put("sort", sort);
        params.put("page", page);
        params.put("pageSize", pageSize);
        return super.execute(ShanghaiDetailRequest.xiaohuaRequest, params);
    }
}
