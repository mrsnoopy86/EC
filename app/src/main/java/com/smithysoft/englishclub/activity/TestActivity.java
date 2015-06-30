package com.smithysoft.englishclub.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.smithysoft.englishclub.R;
import com.smithysoft.englishclub.adapters.CastomAdapter;
import com.smithysoft.englishclub.utils.Item;

import java.util.ArrayList;

/**
 * Created by User on 30.06.2015.
 */
public class TestActivity extends Activity{
    ListView lv;
    ArrayList<Item> list = new ArrayList<>();
    CastomAdapter castomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        castomAdapter = new CastomAdapter(this,list);
        fillArray();

        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(castomAdapter);
        castomAdapter.notifyDataSetChanged();
    }

    private void fillArray() {
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
        list.add(new Item(1 ,"1", "1", "1"));
    }
 }
