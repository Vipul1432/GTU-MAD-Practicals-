package com.example.vipul.p11;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    Button mbtnAdd;
    RecyclerView r1;
    List<Model> models;
    Adapter adapter;
    EditText medName,medAdd;
    Button button;
    int SELECT_PICTURE = 200;
    ArrayList<Uri> list;
    String colum[]={
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mbtnAdd = findViewById(R.id.btnAdd);
        r1 = findViewById(R.id.recycler);
        medName = findViewById(R.id.edName);
        medAdd = findViewById(R.id.edAddress);
        button = findViewById(R.id.button);
        models = new ArrayList<>();
        list=new ArrayList<>();
        //adapter=new Adapter(getApplicationContext(),models,list);
        r1.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        if((ActivityCompat.checkSelfPermission(
                this,colum[0])!= PackageManager.PERMISSION_GRANTED)&&
                (ActivityCompat.checkSelfPermission(
                        this,colum[1])!= PackageManager.PERMISSION_GRANTED)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(colum,123);
            }
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageChooser();
            }
        });
 /* mbtnAdd.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View view) {
 //addStudent();
 }
 });*/
    }
    void imageChooser() {
        // create an instance of the
        // intent of the type image
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        // pass the constant to compare it
        // with the returned requestCode
        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // compare the resultCode with the
            // SELECT_PICTURE constant
            if (requestCode == SELECT_PICTURE) {
                // Get the url of the image from data
                Uri selectedImageUri = data.getData();
                if (null != selectedImageUri) {
                    // update the preview image in the layout
                    Log.e("H", "" + selectedImageUri);
                    list.add(selectedImageUri);
                    models.add(new
                            Model(medName.getText().toString(),medAdd.getText().toString()));
                    adapter = new Adapter(getApplicationContext(), models, list);
                    r1.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    //adapter.notifyDataSetChanged();
                    //IVPreviewImage.setImageURI(selectedImageUri);
                }
            }
        }
    }
    // @SuppressLint("NotifyDataSetChanged")
 /* private void addStudent() {
 models.add(new Model(medName.getText().toString(),medAdd.getText().toString()));
 Log.e("name :",medName.getText().toString());
 adapter = new Adapter(getApplicationContext(),models);
 r1.setAdapter(adapter);
 adapter.notifyDataSetChanged();
 }*/
}