package com.example.myjokeandroidlibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainJokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);
        TextView jokeTextView = (TextView)findViewById(R.id.jokeText);
        jokeTextView.setText(getIntent().getStringExtra("JOKE"));
    }
}
