package com.example.vipul.prac9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.vipul.prac9.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {



    ActivityMainBinding binding;
    String input="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input = binding.nameInput.getText().toString();
                if(!input.equals("")) {
                    Intent intent = new Intent(getApplicationContext(), WishingScreeen.class);
                    intent.putExtra("Name", input);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}