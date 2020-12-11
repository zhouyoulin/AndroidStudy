package com.example.myapplication.base;

import com.shengqu.dl.http.request.host.IHost;

public interface HostManager {
    IHost jhHost =  new IHost() {

        @Override
        public String getHost() {
            return "";
        }

        @Override
        public String getDefaultPath() {
            return "";
        }
    };
}
