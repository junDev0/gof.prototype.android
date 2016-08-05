package com.abc.app.member;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.abc.app.netflixgof.Phone;
import com.abc.app.netflixgof.R;

public class CustomerActivity extends Activity implements View.OnClickListener{
    Button call_bt,back_bt;
    Phone phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_customer);
        init();
    }

    public void init(){
        call_bt = (Button)findViewById(R.id.call_bt);
        back_bt = (Button)findViewById(R.id.back_bt);
        call_bt.setOnClickListener(this);
        back_bt.setOnClickListener(this);
        phone = new Phone(this.getApplicationContext(),CustomerActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.call_bt:
                phone.dial("02-2605-3362");
                break;
            case R.id.back_bt:
                finish();
                onBackPressed();

                //startActivity(new Intent(CustomerActivity.this, MainActivity.class));
                break;
        }
    }
}
