package com.example.jokefactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        TextView gce_result = findViewById(R.id.gce_result);
        gce_result.setText(getIntent().getStringExtra(getString(R.string.jokeEnvelope)));

    }
}
