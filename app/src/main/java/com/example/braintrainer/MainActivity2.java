package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button =findViewById(R.id.button4);
        button.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity2.this,MainActivity.class);
            MainActivity2.this.startActivity(intent);
        });
    }
}