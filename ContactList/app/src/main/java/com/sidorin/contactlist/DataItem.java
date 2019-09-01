package com.sidorin.contactlist;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

public class DataItem {
    public String name, surname, gender, who;
    public int year;
    public int type;

    public DataItem(String name, String surname, String gender, String who, int type) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.who = who;
        this.type = type;
    }

    public DataItem(String name, String surname, int year, int type) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.type = type;
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
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            type[i] = rand.nextInt(who.length);
            DataItem item = new DataItem(names[i], surnames[i], gender[i], who[type[i]], type[i]);
            data.add(item);
        }
        return data;
    }
}
