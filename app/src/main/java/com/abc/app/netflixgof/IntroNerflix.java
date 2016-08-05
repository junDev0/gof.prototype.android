package com.abc.app.netflixgof;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class IntroNerflix extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_intro_nerflix);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(IntroNerflix.this,MainActivity.class));
                finish();
            }
        }, 2000);
    }

    @Override
    protected void onStart() {
        super.onStart();
/*        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
