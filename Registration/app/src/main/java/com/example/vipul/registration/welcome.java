package com.example.vipul.registration;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String password = getIntent().getStringExtra("password");
        String mobile = getIntent().getStringExtra("mobile");
        String gender = getIntent().getStringExtra("gender");

        TextView welcomeTextView = findViewById(R.id.welcome_text_view);
        welcomeTextView.setText("Welcome, " + name + "!");

        TextView detailsTextView = findViewById(R.id.details_text_view);
        detailsTextView.setText("Email: " + email + "\nPassword: " + password + "\nMobile: " + mobile + "\nGender: " + gender);
    }
}
