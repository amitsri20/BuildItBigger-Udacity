//package com.example.amit.builditbigger;
//
//import android.content.Context;
//import android.support.v4.util.Pair;
//
//import java.util.concurrent.ExecutionException;
//
//import static junit.framework.Assert.assertTrue;
//
///**
// * Created by amit on 4/27/2016.
// */
//public class BackendTest implements AsyncResponse{
//    private String joke;
//
//
//    @Override
//    public void processFinish(String output) {
//        joke = output;
//    }
//    public void testBackend() throws ExecutionException, InterruptedException {
//        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
////        task.setListner(new EndpointsAsyncTask.TaskListner() {
////            @Override
////            public void getTaskResult(String result) {
////                joke = result;
////            }
////        }).execute(mContext).get();
//        endpointsAsyncTask.delegate = this;
//        endpointsAsyncTask.execute(new Pair<Context, String>(getTestContext(), "Manfred"));
//        assertTrue(joke, joke.length() > 0);
//    }
//}
