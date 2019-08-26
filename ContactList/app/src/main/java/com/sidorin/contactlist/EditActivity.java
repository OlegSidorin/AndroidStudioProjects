package com.sidorin.contactlist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class EditActivity extends AppCompatActivity {

    private String ed_gender;

    @Override  // создание меню
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override  // выбор действия по пункту меню
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
                return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_edit);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        final EditText ed_name = findViewById(R.id.inputFirstName);
        final EditText ed_surname = findViewById(R.id.inputSecondName);
        final Spinner spiner_type = findViewById(R.id.spinner_of_types);
        final ImageView contactPhoto = findViewById(R.id.contactPhoto);
        ToggleButton tglbtn_MF = findViewById(R.id.toggleMFButton);
        contactPhoto.setImageResource(R.drawable.ic_portrait_black_24dp);

        findViewById(R.id.contactPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_view = new Intent(Intent.ACTION_PICK);
                intent_view.setType("image/*");
                startActivityForResult(intent_view, 101);
            }
        });

        Intent intent = getIntent();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.types));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner_type.setAdapter(adapter);
        spiner_type.setSelection(3);

        if (intent != null && intent.getExtras() != null) {
            ed_name.setText(intent.getExtras().getString("name", ""));
            ed_surname.setText(intent.getExtras().getString("surname", ""));
            ed_gender = intent.getExtras().getString("gender", "");
            if (ed_gender.equals("f")) {
                contactPhoto.setImageResource(R.drawable.ic_female);
                tglbtn_MF.setChecked(false);
            }
            if (ed_gender.equals("m")) {
                contactPhoto.setImageResource(R.drawable.ic_male);
                tglbtn_MF.setChecked(true);
            }
            spiner_type.setSelection(intent.getExtras().getInt("type", 3));

        }

        findViewById(R.id.btn_OK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getIntent().getExtras() != null) {
                    String name = ed_name.getText().toString();
                    String surname = ed_surname.getText().toString();
                    int type = spiner_type.getSelectedItemPosition();
                    String who;
                    if (name.equals("") || surname.equals("")) {
                        Toast.makeText(EditActivity.this, "no data", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("surname", surname);
                    intent.putExtra("type", type);
                    who = String.valueOf(spiner_type.getSelectedItem());
                    intent.putExtra("who", who);
                    intent.putExtra("position", getIntent().getExtras().getInt("position"));
                    setResult(RESULT_OK, intent);
                } else {
                    String name = ed_name.getText().toString();
                    String surname = ed_surname.getText().toString();
                    int type = spiner_type.getSelectedItemPosition();
                    String who;
                    if (name.equals("") || surname.equals("")) {
                        Toast.makeText(EditActivity.this, "no data", Toast.LENGTH_SHORT).show();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("surname", surname);
                    intent.putExtra("type", type);
                    who = String.valueOf(spiner_type.getSelectedItem());
                    intent.putExtra("who", who);
                    setResult(RESULT_OK, intent);
                }
                EditActivity.this.finish();


            }

        });

    }

    public void onToggleMFButtonClicked(View view) {
        ImageView contactPhotoIV = findViewById(R.id.contactPhoto);
        boolean on = ((ToggleButton) view).isChecked();
        if (on) {
            contactPhotoIV.setImageResource(R.drawable.ic_male);
        } else {
            contactPhotoIV.setImageResource(R.drawable.ic_female);
        }
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
