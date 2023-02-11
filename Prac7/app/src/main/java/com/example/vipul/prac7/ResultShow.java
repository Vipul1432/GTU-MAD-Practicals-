package com.example.vipul.prac7;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ResultShow extends AppCompatActivity {
    TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_show);

        tvRes = findViewById(R.id.textView3);
        Intent i = getIntent();
        String ans = i.getStringExtra("Message");
        tvRes.setText(ans);
    }
}
