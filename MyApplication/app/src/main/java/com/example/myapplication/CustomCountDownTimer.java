package com.example.myapplication;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable{

    private int time;
    private CountDownTimerListener countDownTimerListener;
    private Handler handler;
    private boolean isRun;

    /***
     * 1.回调倒计时
     * 2.支持动态传入时间
     * 3.倒计时功能
     * 4.倒计时完成回调
     */

    public CustomCountDownTimer(int time, CountDownTimerListener countDownTimerListener){
        handler = new Handler();
        this.time = time;
        this.countDownTimerListener = countDownTimerListener;

    }

    @Override
    public void run() {
        if (isRun){
            if (this.countDownTimerListener != null){
                this.countDownTimerListener.onTicker(time);
            }
            if (time <= 0){
                this.countDownTimerListener.onFinish();
            }else{
                time--;
                handler.postDelayed(this, 1000);
            }
        }
    }

    public void start(){
        isRun = true;
        handler.post(this);
    }

    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }

    public interface CountDownTimerListener{

        void onTicker(int time);

        void onFinish();
    }
}
