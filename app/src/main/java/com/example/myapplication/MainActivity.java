package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 2;
    private Button ShowG;
    private EditText enterguess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShowG = findViewById(R.id.button2);
        enterguess = findViewById(R.id.guess);
        ShowG.setOnClickListener(view -> {
            String guess_1 = enterguess.getText().toString().trim();
            if (!guess_1.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, Showguess.class);
                intent.putExtra("guess", guess_1);
                intent.putExtra("name", "bond");
                intent.putExtra("age", 34);
                startActivityForResult(intent, REQUEST_CODE);
                // startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Enter Guess", Toast.LENGTH_SHORT).show();
            }
            // startActivity(new Intent(MainActivity.this, Showguess.class));
        });
        //  Toast.makeText(MainActivity.this, "OnCreate() Called", Toast.LENGTH_SHORT).show();


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            assert data != null;
            String message = data.getStringExtra("message_back");
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        }
    }
}