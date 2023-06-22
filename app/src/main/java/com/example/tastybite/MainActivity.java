package com.example.tastybite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.tastybite.Adapters.MainAdapter;
import com.example.tastybite.Models.MainModel;
import com.example.tastybite.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
 ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<MainModel>list=new ArrayList<>();
        list.add(new MainModel(R.drawable.burger1,"Burger","5","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.burger1,"Piza","10","Pizza with extra cheese"));
        list.add(new MainModel(R.drawable.burger1,"Chowmein","50","Spicy Veg Chowmein"));
        list.add(new MainModel(R.drawable.burger1,"Noodles","15","Noodles without oil"));
        list.add(new MainModel(R.drawable.burger1,"Momos","54","Vegetables momos"));
        list.add(new MainModel(R.drawable.burger1,"Spring Rolls","35","Chicken burger with extra cheese"));
        list.add(new MainModel(R.drawable.burger1,"Chole Bhature","58","Chicken burger with extra cheese"));
        MainAdapter adapter=new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.xyz,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.orders:
                startActivity(new Intent(MainActivity.this,OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}