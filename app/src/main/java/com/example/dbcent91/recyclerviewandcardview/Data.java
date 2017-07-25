package com.example.dbcent91.recyclerviewandcardview;

import java.util.ArrayList;

/**
 * Created by dbcent91 on 20/7/17.
 */

public class Data {

    public static ArrayList<Information> getData() {

        ArrayList<Information> data = new ArrayList<>();
        int[] images = {R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker,
                R.drawable.joker};

        String[] Categories = {"Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker",
                "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker",
                "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker", "Batman Joker"};

        for (int i = 0; i < images.length; i++) {

            Information obj = new Information();
            obj.imageId = images[i];
            obj.title = Categories[i];

            data.add(obj);
        }

        return data;
    }
}
