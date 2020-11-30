package com.cp.eightweek.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cp.eightweek.R;
import com.cp.eightweek.db.DBSQLutils;
import com.cp.eightweek.fragment.DongtaiFragment;
import com.cp.eightweek.fragment.MainFragment;
import com.cp.eightweek.fragment.ServeFragment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//    定义获取控件
    TextView home,serve,dongtai;
    private Fragment homeFragment,serveFragment,dongtaiFragment;
    private int FragmentId = 0;
//    标记Fragment
    public static final int FRAGMENT_HOME = 0;
    public static final int FRAGMENT_SERVE = 1;
    public static final int FRAGMENT_DONG = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        // 根据传入的Bundle对象判断Activity是正常启动还是销毁重建
        if(savedInstanceState == null){
            //设置第一个Fragment默认选中
            setFragment(FragmentId);
        }
    }

//    初始化
    public void init(){
//        获取控件
        home = findViewById(R.id.tv_home);
        serve = findViewById(R.id.tv_serve);
        dongtai = findViewById(R.id.tv_dynamic);
//        绑定监听
        home.setOnClickListener(this);
        serve.setOnClickListener(this);
        dongtai.setOnClickListener(this);
    }

//    监听
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_home:
                setFragment(FRAGMENT_HOME);
                break;
            case R.id.tv_serve:
                setFragment(FRAGMENT_SERVE);
                break;
            case R.id.tv_dynamic:
                setFragment(FRAGMENT_DONG);
                break;
        }
    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        FragmentManager mFragmentManager = getSupportFragmentManager();
        //通过FragmentManager获取保存在FragmentTransaction中的Fragment实例
        homeFragment = mFragmentManager.findFragmentByTag("home_fragment");
        serveFragment = mFragmentManager.findFragmentByTag("serve_fragment");
        dongtaiFragment = mFragmentManager.findFragmentByTag("dongtai_fragment");
        //恢复销毁前显示的Fragment
        setFragment(savedInstanceState.getInt("fragment_id"));
    }
    // 还原选项卡
    private void hideFragments(FragmentTransaction transaction){
        if(homeFragment != null){
            //隐藏Fragment
            transaction.hide(homeFragment);
            //将对应菜单栏设置为默认状态
            home.setTextColor(getResources().getColor(R.color.colorInCircle));
            home.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.mipmap.home,0,0);
        }
        if(serveFragment != null){
            transaction.hide(serveFragment);
            serve.setTextColor(getResources().getColor(R.color.colorInCircle));
            serve.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.mipmap.serve,0,0);
        }
        if(dongtaiFragment != null){
            transaction.hide(dongtaiFragment);
            dongtai.setTextColor(getResources().getColor(R.color.colorInCircle));
            dongtai.setCompoundDrawablesWithIntrinsicBounds(0,
                    R.mipmap.dongtai,0,0);
        }
    }
//    配置碎片化窗口Fragment
    private void setFragment(int fragment_id) {
        //获取Fragment管理器
        FragmentManager mFragmentManager = getSupportFragmentManager();
        //开启事务
        FragmentTransaction mTransaction = mFragmentManager.beginTransaction();
        //隐藏所有Fragment
        hideFragments(mTransaction);
        switch (fragment_id){
            default:
                break;
            case FRAGMENT_HOME:
                FragmentId = FRAGMENT_HOME;
                //设置菜单栏为选中状态（修改文字和图片颜色）
                home.setTextColor(getResources().getColor(R.color.colorTextPressed));
                home.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.mipmap.home_pitch,0,0);
                //显示对应Fragment,如果没有实例化,先实例化
                if(homeFragment == null){
                    homeFragment = new MainFragment();
                    mTransaction.add(R.id.content, homeFragment, "home_fragment");
                }else {
                    mTransaction.show(homeFragment);
                }
                break;
            case FRAGMENT_SERVE:
                FragmentId = FRAGMENT_SERVE;
                serve.setTextColor(getResources().getColor(R.color.colorTextPressed));
                serve.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.mipmap.serve_pitch,0,0);
                if(serveFragment == null){
                    serveFragment = new ServeFragment();
                    mTransaction.add(R.id.content, serveFragment, "serve_fragment");
                }else {
                    mTransaction.show(serveFragment);
                }
                break;
            case FRAGMENT_DONG:
                FragmentId = FRAGMENT_DONG;
                dongtai.setTextColor(getResources().getColor(R.color.colorTextPressed));
                dongtai.setCompoundDrawablesWithIntrinsicBounds(0,
                        R.mipmap.dongtai_pitch,0,0);
                if(dongtaiFragment == null){
                    dongtaiFragment = new DongtaiFragment();
                    mTransaction.add(R.id.content, dongtaiFragment, "dongtai_fragment");
                }else {
                    mTransaction.show(dongtaiFragment);
                }
                break;
        }
        //提交事务
        mTransaction.commit();
    }
}