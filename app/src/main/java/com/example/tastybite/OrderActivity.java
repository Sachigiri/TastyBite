package com.example.tastybite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.tastybite.Adapters.MainAdapter;
import com.example.tastybite.Adapters.OrdersAdapter;
import com.example.tastybite.Models.MainModel;
import com.example.tastybite.Models.OrdersModel;
import com.example.tastybite.databinding.ActivityMainBinding;
import com.example.tastybite.databinding.ActivityOrderBinding;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    ActivityOrderBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding=ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
      //  setContentView(R.layout.activity_order);

//ArrayList<OrdersModel>list=new ArrayList<>();
DBHelper helper=new DBHelper(this);
        ArrayList<OrdersModel> list=helper.getOrders();

//        OrdersAdapter adapter=new OrdersAdapter(list,this);
//        binding.orderRecyclerView.setAdapter(adapter);
//        list.add(new OrdersModel(R.drawable.burger1,"Burger","5","123456"));
//        list.add(new OrdersModel(R.drawable.burger1,"Burger","5","123456"));
//        list.add(new OrdersModel(R.drawable.burger1,"Burger","5","123456"));
//        list.add(new OrdersModel(R.drawable.burger1,"Burger","5","123456"));
//        list.add(new OrdersModel(R.drawable.burger1,"Burger","5","123456"));
//        list.add(new OrdersModel(R.drawable.burger1,"Burger","5","123456"));

        OrdersAdapter adapter=new OrdersAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);

    }
}