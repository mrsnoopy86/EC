package com.smithysoft.englishclub.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;

import com.smithysoft.englishclub.R;

/**
 * Created by Admin on 28.06.2015.
 */
public class CreateProfileActivity extends ActionBarActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createprofilescreen);
        initToolbar();

    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Create a profile");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }
}
