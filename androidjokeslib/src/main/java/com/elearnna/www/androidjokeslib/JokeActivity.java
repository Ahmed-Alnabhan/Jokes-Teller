package com.elearnna.www.androidjokeslib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    private TextView txtJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Intent intent = getIntent();
        txtJoke = (TextView) findViewById(R.id.txt_joke);
        if (intent.hasExtra("joke")) {
            txtJoke.setText(intent.getStringExtra("joke"));
        }
    }
}
