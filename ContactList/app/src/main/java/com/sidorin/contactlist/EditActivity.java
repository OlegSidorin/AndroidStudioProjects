package com.sidorin.contactlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        findViewById(R.id.contactPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_view = new Intent(Intent.ACTION_PICK);
                intent_view.setType("image/*");
                startActivityForResult(intent_view, 101);
            }
        });

        Intent intent = getIntent();
        final EditText ed_name = findViewById(R.id.inputFirstName);
        final EditText ed_surname = findViewById(R.id.inputSecondName);
        final Spinner spiner_type = findViewById(R.id.spinner_type);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.types));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_type.setAdapter(adapter);
        spiner_type.setSelection(3);

        findViewById(R.id.btn_makeContact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed_name.getText().toString();
                String surname = ed_surname.getText().toString();
                int type = spiner_type.getSelectedItemPosition();
                if (name.equals("") || surname.equals("")) {
                    Toast.makeText(EditActivity.this, "no data", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent();
                intent.putExtra("name", name);
                intent.putExtra("surname", surname);
                intent.putExtra("type", type);
                intent.putExtra("position", getIntent().getExtras().getInt("position"));
                setResult(RESULT_OK, intent);
                EditActivity.this.finish();

                if (intent != null && intent.getExtras() != null) {
                    ed_name.setText(intent.getExtras().getString("name", ""));
                    ed_surname.setText(intent.getExtras().getString("surname", ""));
                    spiner_type.setSelection(intent.getExtras().getInt("type", 3));
                }
            }

        });

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            ((ImageView) findViewById(R.id.contactPhoto)).setImageURI(uri);
        }
    }


}
