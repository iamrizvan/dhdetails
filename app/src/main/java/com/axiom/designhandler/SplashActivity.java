package com.axiom.designhandler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.axiom.designhandler.main.view.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.from_text)
    TextView fromTxt;
    @BindView(R.id.title_text)
    TextView titleTxt;
    @BindView(R.id.progress_horizontal)
    ProgressBar progressHorizontal;

    int i =10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        //set the font using typeface
        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/quicksand.otf");
        fromTxt.setTypeface(tf);
        titleTxt.setTypeface(tf);


        progressHorizontal.setProgress(i);
        progressHorizontal.setProgressTintList(ColorStateList.valueOf(Color.WHITE));

        new CountDownTimer(2500, 250) {
            @Override
            public void onTick(long l) {
                i= i+10;
                progressHorizontal.setProgress(i);
            }

            @Override
            public void onFinish() {
                finish();
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.reverse_left_to_right, R.anim.reverse_right_to_left);
            }
        }.start();
    }
}