package com.sidorin.contactlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Random;

public class ContactsDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "contacts_db";
    private static final int DB_VERSION = 1;


    public ContactsDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE CONTACTS (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT,"
                + "SURNAME TEXT,"
                + "GENDER TEXT,"
                + "WHO TEXT,"
                + "TYPE INTEGER,"
                + "SRC INTEGER);");

        generateData(db, MyContacts.getAppContext());


    }

    private static void insertContact(SQLiteDatabase db, String name,
                                      String surname, String gender, String who,
                                      int type, int src) {
        ContentValues contactValues = new ContentValues();
        contactValues.put("NAME", name);
        contactValues.put("SURNAME", surname);
        contactValues.put("GENDER", gender);
        contactValues.put("WHO", who);
        contactValues.put("TYPE", type);
        contactValues.put("SRC", src);
        db.insert("CONTACTS", null, contactValues);
    }

    private static void generateData(SQLiteDatabase db, Context context){
        String[] names = context.getResources().getStringArray(R.array.names);
        String[] surnames = context.getResources().getStringArray(R.array.surnames);
        String[] gender = context.getResources().getStringArray(R.array.gender);
        String[] who = context.getResources().getStringArray(R.array.types);
        int[] type = new int[context.getResources().getStringArray(R.array.names).length];
        int[] src = new int[context.getResources().getStringArray(R.array.names).length];

        for (int i = 0; i<50; i++) {
            if (gender[i].equals("f"))  src[i] =  R.drawable.ic_female;
            if (gender[i].equals("m"))  src[i] = R.drawable.ic_male;
        }

        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            type[i] = rand.nextInt(who.length);
            insertContact(db,names[i],surnames[i], gender[i], who[type[i]], type[i], src[i]);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
