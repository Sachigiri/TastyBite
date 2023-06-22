package com.example.tastybite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tastybite.databinding.ActivityDetailBinding;
import com.example.tastybite.databinding.ActivityOrderBinding;

public class DetailActivity extends AppCompatActivity {
ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBHelper helper = new DBHelper(this);
        if(getIntent().getIntExtra("type",0)==1) {
            //   setContentView(R.layout.activity_detail);
            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");
            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", price));
            binding.foodName.setText(name);
            binding.detailDescription.setText(description);


            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insertOrder(


                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            description,
                            name,

                            Integer.parseInt(binding.quantity.getText().toString())


                    );
                    if (isInserted) {
                        Toast.makeText(DetailActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        }
//        else
//        {
//            int id=getIntent().getIntExtra("id",0);
//            Cursor cursor=helper.getOrderById(id);
////            binding.detailImage.setImageResource(cursor.getInt(4));
////            binding.priceLbl.setText(String.format("%d",cursor.getInt(3)));
////            binding.foodName.setText(cursor.getString(6));
////            binding.detailDescription.setText(cursor.getString(5));
////            binding.nameBox.setText(cursor.getString(1));
////            binding.phoneBox.setText(cursor.getString(2));
//        }

    }
}