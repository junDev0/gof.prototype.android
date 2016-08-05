package com.abc.app.netflixgof;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.abc.app.member.CustomerActivity;
import com.abc.app.member.MemberBean;
import com.abc.app.member.MemberServiceImpl;

public class JoinActivity extends Activity implements View.OnClickListener {

    Button menu_login,menu_help,info_btn,basic_bt,special_bt;
    TextView menu_home;
    EditText email_et,password_et;
    View mCustomView;
    LinearLayout join_info,join_card,join_fav;
    MemberServiceImpl service;
    int grade = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar= getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);			//액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);		//액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);
        mCustomView = LayoutInflater.from(JoinActivity.this).inflate(R.layout.main_custombar, null);
        actionBar.setCustomView(mCustomView);
        setContentView(R.layout.activity_join);
        init();

    }

    public void init(){
        menu_home = (TextView) mCustomView.findViewById(R.id.menu_home);
        menu_login = (Button)mCustomView.findViewById(R.id.menu_login);
        menu_help = (Button)mCustomView.findViewById(R.id.menu_help);
        info_btn = (Button) findViewById(R.id.info_btn);
        special_bt = (Button)findViewById(R.id.special_bt);
        basic_bt = (Button)findViewById(R.id.basic_bt);
        special_bt.setOnClickListener(this);
        basic_bt.setOnClickListener(this);
        email_et = (EditText)findViewById(R.id.email_et);
        password_et = (EditText)findViewById(R.id.password_et);
        service = new MemberServiceImpl(JoinActivity.this);
        menu_home.setOnClickListener(this);
        menu_login.setOnClickListener(this);
        menu_help.setOnClickListener(this);
        info_btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_home:
                startActivity(new Intent(JoinActivity.this,MainActivity.class));
                finish();
                break;
            case R.id.menu_login:
                startActivity(new Intent(JoinActivity.this,LoginActivity.class));
                finish();
                break;
            case R.id.menu_help:
                startActivity(new Intent(JoinActivity.this, CustomerActivity.class));
                break;
            case R.id.info_btn:
                MemberBean bean = new MemberBean();
                Intent intent = new Intent(JoinActivity.this,CardActivity.class);
                bean.setEmail(email_et.getText().toString());
                bean.setPassword(password_et.getText().toString());
                bean.setGrade(grade);
                service.regist(bean);
                intent.putExtra("email",bean.getEmail());
                intent.putExtra("grade",grade);
                startActivity(intent);
                break;
            case R.id.special_bt:
                special_bt.setBackgroundResource(R.color.gdColor2);
                basic_bt.setBackgroundResource(R.color.gdColor1);
                grade = 2;
                break;
            case R.id.basic_bt:
                special_bt.setBackgroundResource(R.color.gdColor1);
                basic_bt.setBackgroundResource(R.color.gdColor2);
                grade = 1;
                break;        }
    }
}
