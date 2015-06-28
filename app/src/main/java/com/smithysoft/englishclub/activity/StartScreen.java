package com.smithysoft.englishclub.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.smithysoft.englishclub.R;

/**
 * Created by Admin on 28.06.2015.
 */
public class StartScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
    }

    public void onCreateProfile(View view) {
        Intent intent = new Intent(this, CreateProfileActivity.class);
        startActivity(intent);
        finish();
    }

    public void onSingIn(View view) {
        Toast.makeText(this, "Sing in", Toast.LENGTH_SHORT).show();
    }
}
