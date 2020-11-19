package com.example.myapplication;


import android.os.Handler;
/***
 * 1.回调倒计时
 * 2.支持动态传入时间
 * 3.倒计时功能
 * 4.倒计时完成回调
 */
public class CustomCountDownTimer implements Runnable{

    private int time;
    private CountDownTimerListener countDownTimerListener;
    private Handler handler;
    private boolean isRun;

    /**
     * @param time 计时长度
     * @param countDownTimerListener 计时回调接口
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

    /**
     * 开始计时
     */
    public void start(){
        isRun = true;
        handler.post(this);
    }

    /**
     * 取消计时
     */
    public void cancel(){
        isRun = false;
        // 移除计时
        handler.removeCallbacks(this);
    }

    /**
     * 计时器回调
     */
    public interface CountDownTimerListener{

        // 回调时间
        void onTicker(int time);

        // 回调计时完成
        void onFinish();
    }
}
