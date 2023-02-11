package com.example.vipul.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private EditText mobileEditText;
    private RadioGroup genderRadioGroup;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        confirmPasswordEditText = findViewById(R.id.confirm_password_edit_text);
        mobileEditText = findViewById(R.id.mobile_edit_text);
        genderRadioGroup = findViewById(R.id.gender_radio_group);
        registerButton = findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();
                String mobile = mobileEditText.getText().toString();

                int selectedId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectedId);
                String gender = radioButton.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (mobile.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your mobile number", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, welcome.class);
                intent.putExtra("name", name);
            }
        });
    }
}
