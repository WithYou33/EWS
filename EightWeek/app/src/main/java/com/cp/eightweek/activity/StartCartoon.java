package com.cp.eightweek.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

import com.cp.eightweek.R;

// 启动动画
public class StartCartoon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_cartoon);
        final View view = View.inflate(this, R.layout.activity_start_cartoon, null);
        setContentView(view);
        //渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.3f,1.0f);
        aa.setDuration(500);
        view.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation arg0) {
                redirectTo();
            }
            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationStart(Animation animation) {}
        });
    }
    private void redirectTo(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}