package com.example.yjh.areyouready;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LiberalArtsViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liberal_arts_view);

         // 액션바 감추기
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

    }
}
