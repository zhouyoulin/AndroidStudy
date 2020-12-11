package com.shengqu.dl.http.annotation;

import android.support.annotation.IntDef;

import static com.shengqu.dl.http.annotation.RequestMethod.GET;
import static com.shengqu.dl.http.annotation.RequestMethod.POST;

@IntDef({GET, POST})
public @interface RequestMethod {
    int GET = 1;
    int POST = 2;
}
