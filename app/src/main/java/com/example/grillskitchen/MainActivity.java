package com.example.grillskitchen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv= findViewById(R.id.next);
        tv.setOnClickListener(v -> openActivity3());
    }
    private void  openActivity3() {
        Intent intent=new Intent(this,Start.class);
        startActivity(intent);
    }
}