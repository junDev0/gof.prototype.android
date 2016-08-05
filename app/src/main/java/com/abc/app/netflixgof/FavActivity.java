package com.abc.app.netflixgof;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.abc.app.member.CustomerActivity;

public class FavActivity extends Activity implements View.OnClickListener {
    View mCustomView;
    Button menu_login,menu_help,fav_btn;
    TextView menu_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar= getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);			//액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);		//액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);
        mCustomView = LayoutInflater.from(FavActivity.this).inflate(R.layout.main_custombar, null);
        actionBar.setCustomView(mCustomView);
        setContentView(R.layout.activity_fav);
        init();
    }

    public void init(){
        menu_home = (TextView) mCustomView.findViewById(R.id.menu_home);
        menu_login = (Button)mCustomView.findViewById(R.id.menu_login);
        menu_help = (Button)mCustomView.findViewById(R.id.menu_help);
        fav_btn = (Button)findViewById(R.id.fav_btn);
        menu_home.setOnClickListener(this);
        menu_login.setOnClickListener(this);
        menu_help.setOnClickListener(this);
        fav_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_home:
                startActivity(new Intent(FavActivity.this,MainActivity.class));
                finish();
                break;
            case R.id.menu_login:
                startActivity(new Intent(FavActivity.this,LoginActivity.class));
                finish();
                break;
            case R.id.menu_help:
                startActivity(new Intent(FavActivity.this, CustomerActivity.class));
                break;
            case R.id.fav_btn:
                startActivity(new Intent(FavActivity.this,MainActivity.class));
                finish();
                break;

        }
    }
}
