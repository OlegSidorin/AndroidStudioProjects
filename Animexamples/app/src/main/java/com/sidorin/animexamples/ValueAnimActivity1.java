package com.sidorin.animexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class ValueAnimActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim1);
        valueAnimJava();
        animSize01();
    }

    void animSize01(){
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.animator1);
        set.setTarget(findViewById(R.id.textValueAnim));
        set.start();
    }

    void valueAnimJava() {
        final TextView textView = findViewById(R.id.textValueAnim);
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,200);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setDuration(8000);
        valueAnimator.setRepeatCount(valueAnimator.INFINITE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                textView.setTranslationY((Float) valueAnimator.getAnimatedValue());
            }
        });

        valueAnimator.start();
    }


}
