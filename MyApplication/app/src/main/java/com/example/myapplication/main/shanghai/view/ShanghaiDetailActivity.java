package com.example.myapplication.main.shanghai.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.base.ViewInject;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@ViewInject(mainLayoutId = R.layout.activity_shanghai_detail)
public class ShanghaiDetailActivity extends BaseActivity {

    private static String mShanghaiDetailActivityTag = "ShanghaiDetailActivity";

    private static final String TAG = "ShanghaiDetailActivity";

    @BindView(R.id.iv_shanghai_detail)
    ImageView ivShanghaiDetail;

    @Override
    protected void afterBindView() {
        initAnim();
        initGetData();
    }

    private void initGetData() {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d(TAG, "onFailure: " + e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                Log.d(TAG, "onResponse: "+response.body().string());
            }
        });
    }

    private void initAnim() {
//        ViewCompat.set
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            ViewCompat.setTransitionName(ivShanghaiDetail, mShanghaiDetailActivityTag);
            startPostponedEnterTransition();
        }
    }

    // 共享元素跳转方式
    public static void start_5_0(Activity activity, View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Intent intent = new Intent(activity, ShanghaiDetailActivity.class);
            Pair pair = new Pair(view, mShanghaiDetailActivityTag);
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, pair);
            ActivityCompat.startActivity(activity, intent, optionsCompat.toBundle());
        }
    }
}
