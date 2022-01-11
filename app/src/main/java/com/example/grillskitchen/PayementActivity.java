package com.example.grillskitchen;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.grillskitchen.databinding.ActivityPayementBinding;

import org.json.JSONObject;

public class PayementActivity extends AppCompatActivity {

    ActivityPayementBinding binding1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding1 = ActivityPayementBinding.inflate(getLayoutInflater());
        setContentView(binding1.getRoot());

        String name1 = getIntent().getStringExtra("NAME")+"";
        String phone1 = getIntent().getStringExtra("PHONE")+"";
        String address1 = getIntent().getStringExtra("ADDRESS")+"";
        String quantity = getIntent().getStringExtra("QUANTITY")+"";
        String val = getIntent().getStringExtra("MONEY")+"";

        int gaurav = Integer.parseInt(val);
        int gauravPatyal = Integer.parseInt(quantity);
        String vall = gaurav * gauravPatyal + "";
        String yt = "Rs."+vall;
        int hexa = Integer.parseInt(vall);

        binding1.money.setText(yt);



        }



    }
