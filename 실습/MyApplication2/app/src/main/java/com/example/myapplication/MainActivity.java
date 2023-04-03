package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button)findViewById(R.id.button0);

        button1 = (Button)findViewById(R.id.button1);
        button1.setBackgroundColor(Color.GRAY);
        button1.setTextColor(Color.BLACK);

        button2 = (Button)findViewById(R.id.button2);
        button2.setBackgroundColor(Color.GREEN);
        button2.setTextColor(Color.BLACK);

        button3 = (Button)findViewById(R.id.button3);
        button3.setBackgroundColor(Color.RED);
        button3.setTextColor(Color.BLACK);

        button4 = (Button)findViewById(R.id.button4);
        button4.setBackgroundColor(Color.YELLOW);
        button4.setTextColor(Color.BLACK);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //text 출력
                Toast.makeText(getApplicationContext(), "버튼을 눌렀어요", Toast.LENGTH_SHORT).show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 네이트 열기
                Intent url = new Intent(Intent.ACTION_VIEW, Uri.parse("http://nate.com"));
                startActivity(url);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 전화 걸기
                Intent call = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:911"));
                startActivity(call);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 갤러리 열기
                Intent gopen = new Intent(Intent.ACTION_VIEW,Uri.parse("content://media/internal/images/media"));
                startActivity(gopen);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 종료
                finish();
            }
        });

    }
}