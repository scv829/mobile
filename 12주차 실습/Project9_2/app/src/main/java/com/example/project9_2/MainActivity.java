package com.example.project9_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton idZoomin, idZoomout, idRotate, idBright, idDark, idGray, idBlur ,idEmbos;
    MyGraphicView graphicView;

    static float scaleX = 1, scaleY = 1;
    static float angle = 0;
    static float color = 1;
    static float saturation = 1;
    static boolean embos = false;
    static boolean blur = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("미니 포토샵");

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        graphicView = new MyGraphicView(this);
        pictureLayout.addView(graphicView);

        clickIcons();
    }

    private void clickIcons(){
        idZoomin = (ImageButton) findViewById(R.id.idZoomin);
        idZoomout =(ImageButton) findViewById(R.id.idZoomout);
        idRotate = (ImageButton) findViewById(R.id.idRotate);
        idBright = (ImageButton) findViewById(R.id.idBright);
        idDark = (ImageButton) findViewById(R.id.idDark);
        idGray = (ImageButton) findViewById(R.id.idGray);
        idBlur = (ImageButton) findViewById(R.id.idBlur);
        idEmbos = (ImageButton) findViewById(R.id.idEmbos);

        idZoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX + 0.2f;
                scaleY = scaleY + 0.2f;
                graphicView.invalidate();

            }
        });

        idZoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scaleX = scaleX - 0.2f;
                scaleY = scaleY - 0.2f;
                graphicView.invalidate();

            }
        });

        idRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                angle = angle + 20;
                graphicView.invalidate();
            }
        });

        idBright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = color + 0.2f;
                graphicView.invalidate();
            }
        });

        idDark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = color - 0.2f;
                graphicView.invalidate();
            }
        });

        idGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(saturation == 0) {
                    saturation = 1;
                } else {
                    saturation = 0;
                }
                graphicView.invalidate();
            }
        });

        idBlur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(blur == false) {
                    blur= true;
                } else {
                    blur= false;
                }
                graphicView.invalidate();
            }
        });

        idEmbos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(embos == false) {
                    embos = true;
                } else {
                    embos = false;
                }
                graphicView.invalidate();
            }
        });
    }

    private static class MyGraphicView extends View {

        public MyGraphicView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int cenX = this.getWidth() / 2;
            int cenY = this.getHeight() / 2;
            canvas.scale(scaleX, scaleY, cenX, cenY);
            canvas.rotate(angle, cenX, cenY);

            Paint paint = new Paint();
            float[] array = { color, 0, 0, 0, 0,
                    0, color, 0, 0, 0,
                    0, 0, color, 0, 0,
                    0, 0, 0, 1, 0,};

            ColorMatrix cm = new ColorMatrix(array);
            if(saturation == 0) {
                cm.setSaturation(saturation);
            }
            paint.setColorFilter(new ColorMatrixColorFilter(cm));

            if(blur == true){
                BlurMaskFilter dMask;
                dMask = new BlurMaskFilter(30, BlurMaskFilter.Blur.NORMAL);
                paint.setMaskFilter(dMask);
            }

            if(embos == true){
                EmbossMaskFilter eMask;
                eMask = new EmbossMaskFilter(new float[]{3,3,3}, 0.5f,5,10);
                paint.setMaskFilter(eMask);
            }


            Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.lena256);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;

            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();

        }

    }

}

