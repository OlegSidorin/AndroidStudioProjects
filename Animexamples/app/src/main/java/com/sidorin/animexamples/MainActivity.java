package com.sidorin.animexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.butt_value_anim);
        ObjectAnimator btnAnimator = ObjectAnimator.ofArgb(btn,
                "textColor", 0x00000000, 0xFF000000);
        btnAnimator.setDuration(2000);
        btnAnimator.setRepeatMode(ValueAnimator.REVERSE);
        btnAnimator.setRepeatCount(ValueAnimator.INFINITE);
        btnAnimator.setTarget(findViewById(R.id.butt_value_anim));
        btnAnimator.start();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butt_value_anim:
                startActivity(new Intent(this, ValueAnimActivity1.class));
                overridePendingTransition(R.anim.rotate_anim,R.anim.rotate_anim);
                break;
            case R.id.btn_anim_2:
                startActivity(new Intent(this, MainAnimActivity2.class));
                break;
        }
    }
}
