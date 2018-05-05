package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.example.jokefactory.DisplayActivity;


public class MainActivity extends AppCompatActivity implements EndpointAsyncTask.TaskFinishedCallback {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.joke_progressbar);
        progressBar.setVisibility(View.GONE);
    }

    public void tellJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new EndpointAsyncTask(MainActivity.this).execute();
    }

    @Override
    public void onTaskFinished(String result) {
        Context context = getApplicationContext();
        Intent intent = new Intent(context, DisplayActivity.class);
        intent.putExtra(context.getString(R.string.jokeEnvelope), result);
        context.startActivity(intent);
        progressBar.setVisibility(View.GONE);
    }
}
