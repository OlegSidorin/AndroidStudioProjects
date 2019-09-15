package com.sidorin.contactlist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Random;

public class DataItem {
    public String name, surname, gender, who;
    public int type, src;

    public DataItem(String name, String surname, String gender, String who, int type, int image_src) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.who = who;
        this.type = type;
        this.src = image_src;
    }


/*
    public static ArrayList<DataItem> dataGenerator(Context context, int size) {
        ArrayList<DataItem> data = new ArrayList<>();
        String[] names = context.getResources().getStringArray(R.array.names);
        String[] surnames = context.getResources().getStringArray(R.array.surnames);
        Random rand = new Random();
        for (int i = 0; i< size; i++) {
            DataItem item = new DataItem(names[rand.nextInt(names.length)],
                    surnames[rand.nextInt(names.length)],
                    1990 + rand.nextInt(30),
                    rand.nextInt(4));
            data.add(item);
        }
        return data;
    }
    */


    public static ArrayList<DataItem> dataGenerator(Context context) {
        ArrayList<DataItem> data = new ArrayList<>();
        String[] names = context.getResources().getStringArray(R.array.names);
        String[] surnames = context.getResources().getStringArray(R.array.surnames);
        String[] gender = context.getResources().getStringArray(R.array.gender);
        String[] who = context.getResources().getStringArray(R.array.types);
        int[] type = new int[context.getResources().getStringArray(R.array.names).length];
        int[] src = new int[context.getResources().getStringArray(R.array.names).length];

        for (int i = 0; i < 50; i++) {
            if (gender[i].equals("f")) src[i] = R.drawable.ic_female;
            if (gender[i].equals("m")) src[i] = R.drawable.ic_male;
        }

        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            type[i] = rand.nextInt(who.length);
            DataItem item = new DataItem(names[i], surnames[i], gender[i], who[type[i]], type[i], src[i]);
            data.add(item);
        }
        return data;
    }
}
