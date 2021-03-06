package com.example.amit.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.Jokes;
import com.example.myjokeandroidlibrary.MainJokeActivity;

;

public class MainActivity extends AppCompatActivity implements AsyncResponse{


    Jokes jokes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokes = new Jokes();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
//        Toast.makeText(this, jokes.tellJokes(), Toast.LENGTH_SHORT).show();
//        Intent jokeintent = new Intent(this, MainJokeActivity.class);
//        jokeintent.putExtra("JOKE",jokes.tellJokes());
//        startActivity(jokeintent);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.delegate = this;
        endpointsAsyncTask.execute(new Pair<Context, String>(this, "Manfred"));
    }

    @Override
    public void processFinish(String output){
        //Here you will receive the result fired from async class
        //of onPostExecute(result) method.
        Intent jokeintent = new Intent(this, MainJokeActivity.class);
        jokeintent.putExtra("JOKE",output);
        startActivity(jokeintent);
    }


}
