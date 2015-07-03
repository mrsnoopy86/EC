package com.smithysoft.englishclub.utils;

import android.graphics.Color;

import com.smithysoft.englishclub.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 03.07.2015.
 */
public class Utils {
    public static final List<Friend> friends = new ArrayList<>();

    static {
        friends.add(new Friend(R.drawable.liza, "MAMKA", R.color.sienna, "Sport", "Literature", "Music", "Art", "Technology"));
        friends.add(new Friend(R.drawable.masha, "DOCHKA", R.color.saffron, "Travelling", "Flights", "Books", "Painting", "Design"));
        friends.add(new Friend(R.drawable.philip, "ZADROT №1", R.color.green, "Sales", "Pets", "Skiing", "Hairstyles", "Сoffee"));
        friends.add(new Friend(R.drawable.serg, "ZADROT №2", R.color.pink, "Android", "Development", "Design", "Wearables", "Pets"));
        friends.add(new Friend(R.drawable.liza, "MAMKA", R.color.orange, "Sport", "Literature", "Music", "Art", "Technology"));
        friends.add(new Friend(R.drawable.masha, "DOCHKA", R.color.saffron, "Travelling", "Flights", "Books", "Painting", "Design"));
        friends.add(new Friend(R.drawable.philip, "ZADROT №1", R.color.green, "Sales", "Pets", "Skiing", "Hairstyles", "Сoffee"));
        friends.add(new Friend(R.drawable.serg, "ZADROT №2", R.color.purple, "Android", "Development", "Design", "Wearables", "Pets"));
    }
}
