package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Showguess extends AppCompatActivity {
    private TextView showGuessTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showguess);

        Bundle extra = getIntent().getExtras();
        showGuessTextview = findViewById(R.id.recived_view);
        if (extra != null) {
            showGuessTextview.setText(extra.getString("guess"));
            Log.d("Name extra", "onCreate: " + extra.getString("name"));
            Log.d("Name extra 2", "onCreate: " + extra.getInt("age"));
        }
//        if (getIntent().getStringExtra("guess") != null) {
//            showGuessTextview.setText(getIntent().getStringExtra("guess"));
//        }
        showGuessTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                intent.putExtra("message_back", "From Second Activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}