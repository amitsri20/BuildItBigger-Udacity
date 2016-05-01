package com.example.amit.builditbigger;

import android.content.Context;
import android.support.v4.util.Pair;
import android.test.AndroidTestCase;

import java.util.concurrent.ExecutionException;

/**
 * Created by amit on 4/27/2016.
 */
public class BackendTest extends AndroidTestCase implements AsyncResponse{
    private String joke;


    @Override
    public void processFinish(String output) {
        joke = output;
    }
    public void testBackend() throws ExecutionException, InterruptedException {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.delegate = this;
        endpointsAsyncTask.execute(new Pair<Context, String>(getContext(), "Manfred"));
        assertTrue(joke, joke.length() > 0);
    }
}
