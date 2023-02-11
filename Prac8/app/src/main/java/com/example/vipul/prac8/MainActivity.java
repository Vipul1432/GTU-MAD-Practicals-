package com.example.vipul.prac8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);

        //admin and admin

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("Vipul") && password.getText().toString().equals("Vipul@123")){
                    //correct
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("name", username.getText().toString());
                    startActivity(intent);
                }else
                    //incorrect
                    Toast.makeText(MainActivity.this,"LOGIN FAILED !!!",Toast.LENGTH_SHORT).show();
            }
        });


    }
}