package com.example.myapplication.base;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME) // 运行时注解，回消耗性能
@Target(TYPE) //类 接口
public @interface ViewInject {
    int mainLayoutId() default -1;
}
