package com.example.myapplication.main.tools;

import android.support.annotation.IntDef;

import static com.example.myapplication.main.tools.MainConstantTools.BEIJING;
import static com.example.myapplication.main.tools.MainConstantTools.HANGZHOU;
import static com.example.myapplication.main.tools.MainConstantTools.SHANGHAI;
import static com.example.myapplication.main.tools.MainConstantTools.SHENZHEN;

@IntDef({SHANGHAI, HANGZHOU, BEIJING, SHENZHEN})
public @interface MainConstantTools {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
