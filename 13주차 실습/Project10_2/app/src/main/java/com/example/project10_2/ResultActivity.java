package com.example.project10_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];

        Integer tvID[] = {
                R.id.tv1, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6,
                R.id.tv7, R.id.tv8, R.id.tv9 };

        Integer rbarID[] = {
                R.id.rbar1, R.id.rbar2, R.id.rbar3,
                R.id.rbar4, R.id.rbar5, R.id.rbar6,
                R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        Integer imageFileId[] = {
                R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
                R.drawable.pic7, R.drawable.pic8, R.drawable.pic9 };


        for(int i = 0; i < voteResult.length; i++){
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        for(int i = 0; i < voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }


        ImageView selectImage = (ImageView) findViewById(R.id.selectImage);
        TextView selectImageText = (TextView) findViewById(R.id.selectImageName);
        for(int i = 0 , choice = 0; i < voteResult.length; i++){
            if(choice <= voteResult[i]){
                choice = voteResult[i];
                selectImage.setImageResource(imageFileId[i]);
                selectImageText.setText(imageName[i]);
            }
        }


        Button btnReturn = (Button) findViewById(R.id.btnResult);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
