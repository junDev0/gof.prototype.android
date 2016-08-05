package com.abc.app.netflixgof;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.abc.app.member.CustomerActivity;
import com.abc.app.member.MemberPaymentCard;
import com.abc.app.member.MemberServiceImpl;

public class CardActivity extends Activity implements View.OnClickListener {
    private View mCustomView;
    private Button card_btn;
    private String email,company,birth;
    private EditText cardNum_et,cardYear_et,cardMonth_et,name_et,phoneNum_et
            ,birthYear_et,birthMonth_et,birthDay_et;
    private int grade=1;
    private CheckBox chk_hana,chk_kukmin,chk_sinhan;
    MemberServiceImpl service;
    Button menu_login,menu_help;
    TextView menu_home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar= getActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);			//액션바 아이콘을 업 네비게이션 형태로 표시합니다.
        actionBar.setDisplayShowTitleEnabled(false);		//액션바에 표시되는 제목의 표시유무를 설정합니다.
        actionBar.setDisplayShowHomeEnabled(false);
        mCustomView = LayoutInflater.from(CardActivity.this).inflate(R.layout.main_custombar, null);
        actionBar.setCustomView(mCustomView);

        setContentView(R.layout.activity_card);
        init();
    }

    public void init(){
        card_btn = (Button)findViewById(R.id.card_btn);
        menu_home = (TextView) mCustomView.findViewById(R.id.menu_home);
        menu_login = (Button)mCustomView.findViewById(R.id.menu_login);
        menu_help = (Button)mCustomView.findViewById(R.id.menu_help);
        chk_hana = (CheckBox)findViewById(R.id.chk_hana);
        chk_kukmin = (CheckBox)findViewById(R.id.chk_kukmin);
        chk_sinhan = (CheckBox)findViewById(R.id.chk_sinhan);
        cardNum_et = (EditText)findViewById(R.id.cardNum_et);
        cardYear_et = (EditText)findViewById(R.id.cardYear_et);
        cardMonth_et = (EditText)findViewById(R.id.cardMonth_et);
        name_et = (EditText)findViewById(R.id.name_et);
        phoneNum_et = (EditText)findViewById(R.id.phoneNum_et);
        birthYear_et = (EditText)findViewById(R.id.birthYear_et);
        birthMonth_et = (EditText)findViewById(R.id.birthMonth_et);
        birthDay_et = (EditText)findViewById(R.id.birthDay_et);

        service = new MemberServiceImpl(CardActivity.this);
        menu_home.setOnClickListener(this);
        menu_login.setOnClickListener(this);
        menu_help.setOnClickListener(this);
        card_btn.setOnClickListener(this);
        chk_hana.setOnClickListener(this);
        chk_kukmin.setOnClickListener(this);
        chk_sinhan.setOnClickListener(this);
        email = getIntent().getStringExtra("email");
        grade = getIntent().getIntExtra("grade",1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.card_btn:
                MemberPaymentCard pcmBean = new MemberPaymentCard();
                birth = birthYear_et.getText().toString()+birthMonth_et.getText().toString()+
                        birthDay_et.getText().toString();
                birth = birth.substring(2,birth.length());
                pcmBean.setEmail(email);
                pcmBean.setCompany(company);
                pcmBean.setCardNum(cardNum_et.getText().toString());
                pcmBean.setName(name_et.getText().toString());
                pcmBean.setBirth(birth);
                pcmBean.setPhone(phoneNum_et.getText().toString());
                pcmBean.setGrade(grade);
                service.update(pcmBean);
                 startActivity(new Intent(CardActivity.this,FavActivity.class));
                break;

            case R.id.chk_hana :
                chk_hana.setChecked(true);
                chk_kukmin.setChecked(false);
                chk_sinhan.setChecked(false);
                company = "하나";
                break;
            case R.id.chk_kukmin :
                chk_hana.setChecked(false);
                chk_kukmin.setChecked(true);
                chk_sinhan.setChecked(false);
                company = "국민";
                break;
            case R.id.chk_sinhan :
                chk_hana.setChecked(false);
                chk_kukmin.setChecked(false);
                chk_sinhan.setChecked(true);
                company = "신한";
                break;
            case R.id.menu_home:
                startActivity(new Intent(CardActivity.this,MainActivity.class));
                finish();
                break;
            case R.id.menu_login:
                startActivity(new Intent(CardActivity.this,LoginActivity.class));
                finish();
                break;
            case R.id.menu_help:
                startActivity(new Intent(CardActivity.this, CustomerActivity.class));
                break;        }
    }
}
