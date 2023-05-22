package com.example.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button btnPrev,btnNext;
    myPictureView mypicture;
    int curNum=1;
    File[] imageFiles;
    String imageFname;
    TextView textView1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지뷰어");
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        btnPrev=(Button)findViewById(R.id.btnPrev);
        btnNext=(Button)findViewById(R.id.btnNext);
        textView1=(TextView)findViewById(R.id.textview1);
        mypicture=(myPictureView)findViewById(R.id.myPictureView1);
        imageFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        imageFname = imageFiles[curNum].toString();
        mypicture.imagePath=imageFname;
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum<=1)
                {
                    curNum=imageFiles.length;
                    imageFname=imageFiles[curNum-1].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();
                    textView1.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));
                }
                else
                {
                    curNum--;
                    imageFname=imageFiles[curNum-1].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();
                    textView1.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum>=imageFiles.length)
                {
                    curNum=1;
                    imageFname=imageFiles[curNum-1].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();
                    textView1.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));

                }
                else {curNum++;
                    imageFname=imageFiles[curNum-1].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();}
                textView1.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));
            }
        });
    }
}