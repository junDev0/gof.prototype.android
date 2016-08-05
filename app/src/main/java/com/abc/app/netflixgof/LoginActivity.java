package com.abc.app.netflixgof;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.abc.app.member.CustomerActivity;
import com.abc.app.member.MemberBean;
import com.abc.app.member.MemberServiceImpl;

public class LoginActivity extends Activity implements View.OnClickListener {

    Button menu_back,menu_help,menu_home,login_bt;
    View mCustomView;
    EditText email_et,password_et;
    MemberServiceImpl service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar= getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);			//액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);		//액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);
        mCustomView = LayoutInflater.from(LoginActivity.this).inflate(R.layout.login_custombar, null);
        actionBar.setCustomView(mCustomView);
        setContentView(R.layout.activity_login);
        init();
    }

    public void init(){
        menu_help = (Button)mCustomView.findViewById(R.id.menu_help);
        menu_back = (Button)mCustomView.findViewById(R.id.menu_back);
        email_et = (EditText)findViewById(R.id.email_et);
        password_et = (EditText)findViewById(R.id.password_et);
        login_bt = (Button)findViewById(R.id.login_bt);

        service = new MemberServiceImpl(LoginActivity.this);
        menu_help.setOnClickListener(this);
        menu_back.setOnClickListener(this);
        email_et.setOnClickListener(this);
        password_et.setOnClickListener(this);
        login_bt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_help:
                startActivity(new Intent(LoginActivity.this, CustomerActivity.class));
                break;
            case R.id.menu_back:
                finish();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                break;
            case R.id.email_et:
                break;
            case R.id.password_et:
                break;
            case R.id.login_bt:
                MemberBean bean = new MemberBean();
                bean.setEmail(email_et.getText().toString());
                bean.setPassword(password_et.getText().toString());
                if(service.login(bean)){
                    Toast.makeText(LoginActivity.this,"JoinSucc" +
                            "Email: "+email_et.getText().toString()+"" +
                            "Password: "+password_et.getText().toString(),Toast.LENGTH_LONG).show();

/*
                    Intent intent = new Intent(this, HomeActivity.class);
                    intent.putExtra("email", email_et.getText().toString());
                    startActivity(intent);
*/
                } else{
                    Toast.makeText(LoginActivity.this,"fail",Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
