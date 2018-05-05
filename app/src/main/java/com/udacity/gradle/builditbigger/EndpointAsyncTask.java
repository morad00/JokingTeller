package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

/**
 * Created by Mourad on 1/22/2018.
 */

public class EndpointAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private final TaskFinishedCallback callback;

    public interface TaskFinishedCallback {
        void onTaskFinished(String result);
    }

    public EndpointAsyncTask(TaskFinishedCallback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://jokebackend-6a768.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        try {
            return myApiService.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        callback.onTaskFinished(result);
    }
}
