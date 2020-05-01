package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername=findViewById(R.id.etUserName);
    }

    public void external_public(View view) {

        String name=etUsername.getText().toString();
        File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file1=new File(file,"ahmedpublic.txt");

        dataStore(name,file1);


    }

    public void external_Private(View view) {

        String name=etUsername.getText().toString();
        File file=getExternalFilesDir("sadoon");
        File file1=new File(file,"ahmedprivate.txt");

        dataStore(name,file1);
    }


    private void dataStore(String name, File file1) {
        FileOutputStream fileOutputStream=null ;
        try {
            fileOutputStream=new FileOutputStream(file1);
            fileOutputStream.write(name.getBytes());
            Toast.makeText(this,name+" Data stored successfully " +file1.getAbsolutePath(),Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        finally {
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public void Database(View view) {
        Intent intent=new Intent(this,DBActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Go to Database",Toast.LENGTH_SHORT).show();
    }
}
