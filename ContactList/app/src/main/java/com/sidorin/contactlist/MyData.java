package com.sidorin.contactlist;

import android.content.Context;

import java.util.ArrayList;
import java.util.Random;

public class MyData {
    public String name, surname, gender, who;
    public int year;
    public int type;

    public MyData(String name, String surname, String gender, String who) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.who = who;
    }

    public MyData(String name, String surname, int year, int type) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.type = type;
    }
/*
    public static ArrayList<MyData> dataGenerator(Context context, int size) {
        ArrayList<MyData> data = new ArrayList<>();
        String[] names = context.getResources().getStringArray(R.array.names);
        String[] surnames = context.getResources().getStringArray(R.array.surnames);
        Random rand = new Random();
        for (int i = 0; i< size; i++) {
            MyData item = new MyData(names[rand.nextInt(names.length)],
                    surnames[rand.nextInt(names.length)],
                    1990 + rand.nextInt(30),
                    rand.nextInt(4));
            data.add(item);
        }
        return data;
    }
    */

    public static ArrayList<MyData> dataGenerator(Context context, int size) {
        ArrayList<MyData> data = new ArrayList<>();
        String[] names = context.getResources().getStringArray(R.array.names);
        String[] surnames = context.getResources().getStringArray(R.array.surnames);
        String[] gender = context.getResources().getStringArray(R.array.gender);
        String[] who = context.getResources().getStringArray(R.array.types);
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            MyData item = new MyData(names[i], surnames[i], gender[i], who[rand.nextInt(who.length)]);
            data.add(item);
        }
        return data;
    }
}
