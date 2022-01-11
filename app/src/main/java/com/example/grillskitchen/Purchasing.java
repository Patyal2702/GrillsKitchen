package com.example.grillskitchen;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.grillskitchen.Adapters.MainAdapter;
import com.example.grillskitchen.Models.MainModel;
import com.example.grillskitchen.databinding.ActivityPurchasingBinding;

import java.util.ArrayList;


public class Purchasing extends AppCompatActivity {

     ActivityPurchasingBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            binding = ActivityPurchasingBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();

        list.add(new MainModel(R.drawable.burger,"Burger","50","Chicken Burger with Extra cheese"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","100","A delectable combination of cheese and juicy tomato "));
        list.add(new MainModel(R.drawable.coke3,"Coke","40"," Carbonated soft drink 750ml"));
        list.add(new MainModel(R.drawable.chowmein,"Chow mein","50","Loaded with fresh vegetables"));
        list.add(new MainModel(R.drawable.hotdogs,"Hot Dog","50","Ground meat with seasonings"));
        list.add(new MainModel(R.drawable.icecream3,"IceCream","60","2 Scoops"));
        list.add(new MainModel(R.drawable.sandwich,"Sandwich","50","Ham and cheese Toasted Sandwich"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);



    }


    }