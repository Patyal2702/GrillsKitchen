package com.example.grillskitchen;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Start extends AppCompatActivity {
Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        login=findViewById(R.id.Login);
        signup=findViewById(R.id.Signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openloginpage();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensignpage();
            }
        });
    }

    private void opensignpage() {
        Intent intent=new Intent(this,Signup.class);
        startActivity(intent);
    }

    private void openloginpage() {
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }
}