package com.example.form;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText name, pass, email, phone, country;
    Button insert, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.username);
        pass = findViewById(R.id.password);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        country = findViewById(R.id.country);
        insert = findViewById(R.id.submit);
        view = findViewById(R.id.view);
        DB = new DBHelper(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String passTXT = pass.getText().toString();
                String emailTXT = email.getText().toString();
                String phoneTXT = phone.getText().toString();
                String countryTXT = country.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, passTXT, emailTXT, phoneTXT, countryTXT);
                if (checkinsertdata == true)
                    Toast.makeText(MainActivity.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }
        });

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = DB.getdata();
                        if (res.getCount() == 0) {
                            Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Name :" + res.getString(0) + "\n");
                            buffer.append("Password :" + res.getString(1) + "\n");
                            buffer.append("Email :" + res.getString(2) + "\n\n");
                            buffer.append("Phone :" + res.getString(3) + "\n\n");
                            buffer.append("Country :" + res.getString(4) + "\n\n");
                        }

                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setCancelable(true);
                        builder.setTitle("User Entries");
                        builder.setMessage(buffer.toString());
                        builder.show();
                    }
                });
    }
}

