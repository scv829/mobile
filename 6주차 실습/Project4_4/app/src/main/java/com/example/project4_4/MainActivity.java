package com.example.project4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch chkAgree;
    RadioGroup rGroup1;
    RadioButton rdoQ,rdoR,rdoS;
    Button btnQuit,btnReturn;
    ImageView imgAnd;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        chkAgree = (Switch) findViewById(R.id.ChkAgree);

        text1 = (TextView) findViewById(R.id.Text1);
        text2 = (TextView) findViewById(R.id.Text2);

        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        rdoQ = (RadioButton) findViewById(R.id.RdoQ);
        rdoS = (RadioButton) findViewById(R.id.RdoS);
        rdoR = (RadioButton) findViewById(R.id.RdoR);

        btnQuit = (Button) findViewById(R.id.BtnQuit);
        btnReturn = (Button) findViewById(R.id.BtnReturn);

        imgAnd = (ImageView) findViewById(R.id.ImgAnd);

        chkAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(chkAgree.isChecked() == true){
                    text2.setVisibility(View.VISIBLE);
                    rGroup1.setVisibility(View.VISIBLE);
                    imgAnd.setVisibility(View.VISIBLE);
                }
                else{
                    text2.setVisibility(View.INVISIBLE);
                    rGroup1.setVisibility(View.INVISIBLE);
                    imgAnd.setVisibility(View.VISIBLE);
                }
            }
        });

        rdoQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAnd.setImageResource(R.drawable.q);
            }
        });
        rdoR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAnd.setImageResource(R.drawable.r);
            }
        });
        rdoS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAnd.setImageResource(R.drawable.s);
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chkAgree.setChecked(false);
                rdoQ.setChecked(false);
                rdoR.setChecked(false);
                rdoS.setChecked(false);
                text2.setVisibility(View.INVISIBLE);
                rGroup1.setVisibility(View.INVISIBLE);
                imgAnd.setVisibility(View.INVISIBLE);
                imgAnd.setImageResource(0);
            }
        });

        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}