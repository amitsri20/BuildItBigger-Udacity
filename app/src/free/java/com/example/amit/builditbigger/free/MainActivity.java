package com.example.amit.builditbigger.free;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.Jokes;
import com.example.amit.builditbigger.AsyncResponse;
import com.example.amit.builditbigger.EndpointsAsyncTask;
import com.example.amit.builditbigger.R;
import com.example.myjokeandroidlibrary.MainJokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

;

public class MainActivity extends AppCompatActivity implements AsyncResponse{


    Jokes jokes;
    String mJoke;
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokes = new Jokes();

        //Initialting interestial ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                loadAd();
                startJokeActivity(mJoke);
            }
        });
        loadAd();
    }

    private void startJokeActivity(String joke) {
        Intent jokeintent = new Intent(this, MainJokeActivity.class);
        jokeintent.putExtra("JOKE",joke);
        startActivity(jokeintent);
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

        if (!mInterstitialAd.isLoaded() && mInterstitialAd.isLoading())
            loadAd();

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.delegate = this;
        endpointsAsyncTask.execute(new Pair<Context, String>(this, "-Free version"));
    }

    @Override
    public void processFinish(String output){
        //Here you will receive the result fired from async class
        //of onPostExecute(result) method.
        Intent jokeintent = new Intent(this, MainJokeActivity.class);
        jokeintent.putExtra("JOKE",output);
        mJoke = output;
        if (mInterstitialAd.isLoaded())
            mInterstitialAd.show();
        else
            startJokeActivity(mJoke);
//        startActivity(jokeintent);
    }

    private void loadAd() {
        final AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

}
