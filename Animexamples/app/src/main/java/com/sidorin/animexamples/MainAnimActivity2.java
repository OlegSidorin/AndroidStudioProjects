package com.sidorin.animexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainAnimActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_anim2);

    }

    public void onClickFrame(View v){
        AnimationDrawable animationDrawable = (AnimationDrawable) findViewById(R.id.imageView).getBackground();
        animationDrawable.start();
        anim_rotate();
    }

    public void anim_rotate(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.rotate_anim);
        findViewById(R.id.button_start_frame).startAnimation(animation);
    }
}
