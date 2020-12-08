package com.cp.eightweek.activity.dengruzhuce;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cp.eightweek.R;

public class EnterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText text_id,text_password;
    private CheckBox xian_pasword,remember_password;
    private TextView wang_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
//        初始化
        init();
//        密码显示
        xian_pasword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    text_password.setTransformationMethod(null);
                else
                    text_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        });
    }

    public void init(){

        text_id = findViewById(R.id.text_name);
        text_password = findViewById(R.id.text_password);
        xian_pasword = findViewById(R.id.visible_password);
        remember_password = findViewById(R.id.remember_password);
        wang_password = findViewById(R.id.wangji_password);

        remember_password.setOnClickListener(this);
        wang_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

//                记住密码
            case R.id.remember_password:

                break;
//                忘记密码
            case R.id.wangji_password:
                AlertDialog.Builder builder  = new AlertDialog.Builder(EnterActivity.this);
                builder.setTitle("提示" ) ;
                builder.setMessage("请联系管理员找回密码！" ) ;
                builder.setPositiveButton("是" ,  null );
                builder.show();
                break;
//                登入
            case R.id.affim:

                break;
            default:
                break;
        }

    }
}