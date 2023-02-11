package com.example.vipul.prac7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    EditText medMsg;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        medMsg = findViewById(R.id.edMsg);
        btn1 = findViewById(R.id.button3);

        btn1.setOnClickListener(view -> {
            String msg = medMsg.getText().toString();
            Intent i = new Intent(getApplicationContext(), ResultShow.class);
            i.putExtra("Message", msg);
            startActivity(i);
        });
    }
}