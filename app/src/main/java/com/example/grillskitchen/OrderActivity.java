package com.example.grillskitchen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.grillskitchen.Adapters.OrdersAdapter;
import com.example.grillskitchen.Models.OrdersModel;
import com.example.grillskitchen.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {


    ActivityOrderBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<OrdersModel> list = new ArrayList<>();
        list.add(new OrdersModel(R.drawable.burger,"Burger","50","789456"));
        list.add(new OrdersModel(R.drawable.burger,"Pizza","100","789566"));
        list.add(new OrdersModel(R.drawable.burger,"Coke","40","456523"));
        list.add(new OrdersModel(R.drawable.burger,"Chow Mein","50","879456"));
        list.add(new OrdersModel(R.drawable.burger,"Hot Dog","50","354698"));
        list.add(new OrdersModel(R.drawable.burger,"Ice Cream","60","789258"));
        list.add(new OrdersModel(R.drawable.burger,"Sandwich","50","741258"));

        OrdersAdapter adapter = new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);


    }
}