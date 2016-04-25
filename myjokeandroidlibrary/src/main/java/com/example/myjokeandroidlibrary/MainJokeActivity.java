package com.example.myjokeandroidlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainJokeActivity extends AppCompatActivity {

    private ProgressBar spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_joke);

        spinner=(ProgressBar)findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);
        TextView jokeTextView = (TextView)findViewById(R.id.jokeText);
        jokeTextView.setText(getIntent().getStringExtra("JOKE"));
        spinner.setVisibility(View.GONE);
    }
}
