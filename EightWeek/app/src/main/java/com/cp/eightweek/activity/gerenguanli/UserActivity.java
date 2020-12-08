package com.cp.eightweek.activity.gerenguanli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cp.eightweek.R;
import com.cp.eightweek.activity.dengruzhuce.EnterActivity;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView u_name;
    private ImageView tou_pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        init();
    }

    public void init(){

        tou_pic = findViewById(R.id.user_touxiang);
        tou_pic.setOnClickListener(this);
        u_name = findViewById(R.id.user_name);
        u_name.setOnClickListener(this);

        findViewById(R.id.user_back).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_name:
                Intent intent=new Intent(UserActivity.this, EnterActivity.class);
                startActivity(intent);
                break;
            case R.id.user_touxiang:

                break;

            case R.id.user_back:

                break;
            default:
                break;
        }
    }
}