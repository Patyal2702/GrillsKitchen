package com.example.grillskitchen;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.grillskitchen.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

   static int val = 0;
    String qty;
    ActivityDetailBinding binding;

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int image = getIntent().getIntExtra("image",0);
        int price = Integer.parseInt(getIntent().getStringExtra("price"));
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);
        binding.proceLbl.setText(String.format("%d",price));
        binding.foodName.setText(name);
        binding.detailDescription.setText(description);

       String s =  binding.quantity.getText()+"";
        val = Integer.parseInt(s);

       binding.add.setOnClickListener(v -> {

           val = val + 1;
           binding.quantity.setText(val+"");
           qty = val+"";
       });

       binding.sub.setOnClickListener(v -> {
           if(val>1){
               val--;
               binding.quantity.setText(val+"");
               qty = val+"";
           }
       });



        String phone = binding.phoneBox.getText() + "";
        String address = binding.AddressBox.getText()+"";
        String namee = binding.consumerName.getText()+"";
        String money = binding.proceLbl.getText()+"";

       binding.orderBtn.setOnClickListener(v -> {
           Intent intent = new Intent(this,PayementActivity.class);
           intent.putExtra("NAME", namee);
           intent.putExtra("PHONE",phone);
           intent.putExtra("ADDRESS",address);
           intent.putExtra("QUANTITY",qty);
           intent.putExtra("MONEY",money);
           startActivity(intent);
       });
    }
}