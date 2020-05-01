package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DBActivity extends AppCompatActivity {

    TextView tvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        tvUsername=findViewById(R.id.tv_UserName);
    }


    public void Back(View view) {
        Intent intent = new Intent(this, DBActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Go to Main Page", Toast.LENGTH_SHORT).show();
    }

    private String getData(File file1) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(file1);

            int read = -1;
            StringBuffer stringBuffer = new StringBuffer();

            while ((read = fileInputStream.read()) != -1) {

                stringBuffer.append((char) read);

            }
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return null;
    }

    public void External_Private(View view) {
        File file=getExternalFilesDir("sadoon");
        File file1=new File(file,"ahmedprivate.txt");
        String name=getData(file1);

        if (name!=null){
            tvUsername.setText(name);
        }
        else {
            tvUsername.setText("No Data");
        }

    }

    public void External_Public(View view) {
        File file= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file1=new File(file,"ahmedpublic.txt");
        String name=getData(file1);

        if (name!=null){
            tvUsername.setText(name);
        }
        else {
            tvUsername.setText("No Data");
        }
    }
}
