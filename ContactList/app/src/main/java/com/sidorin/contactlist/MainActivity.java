package com.sidorin.contactlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.setPhoto).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent_view = new Intent(Intent.ACTION_PICK);
                intent_view.setType("image/*");
                startActivityForResult(intent_view,101);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK){
            Uri uri = data.getData();
            ((ImageView) findViewById(R.id.contactPhoto)).setImageURI(uri);
        }
    }
}
