package com.example.vipul.prac7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btn1, btn2;
    TextView mTv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);

        mTv1 = findViewById(R.id.textView);


        Intent intent = getIntent();
        String msg = intent.getStringExtra("Message");
        mTv1.setText(msg);
        btn1.setOnClickListener(view -> {
            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
            startActivity(i);
        });


        btn2.setOnClickListener(view -> {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.marwadiuniversity.ac.in/"));
            startActivity(i);
        });
    }
}