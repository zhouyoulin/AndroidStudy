package com.example.myapplication;

public class SplashTimerPresenter {

    private SplashActivity mActivity;
    private CustomCountDownTimer timer;

    public SplashTimerPresenter(SplashActivity splashActivity) {
        this.mActivity = splashActivity;
    }

    public void initTimer() {
        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.CountDownTimerListener() {
            @Override
            public void onTicker(int time) {
                mActivity.setTvTimer(time + "");
            }

            @Override
            public void onFinish() {
                mActivity.setTvTimer(mActivity.getString(R.string.skip));
                mActivity.setTvClickable(true);
            }
        });
        timer.start();
    }

    public void cancel() {
        timer.cancel();
    }
}
