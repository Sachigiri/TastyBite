package com.example.tastybite.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tastybite.DetailActivity;
import com.example.tastybite.Models.MainModel;
import com.example.tastybite.Models.OrdersModel;
import com.example.tastybite.R;

import java.util.ArrayList;

public class OrdersAdapter  extends RecyclerView.Adapter<OrdersAdapter.viewHolder>{
    ArrayList<OrdersModel>list;
    Context context;

    public OrdersAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final OrdersModel model=list.get(position);
        holder.orderimage.setImageResource(model.getOrderimage());
        holder. orderItemName.setText(model. getOrderItemName());
        holder.orderNumber.setText(model.getOrderNumber());
        holder.textView9.setText(model.getTextView9());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context, DetailActivity.class);
                intent.putExtra("id",Integer.parseInt(model.getOrderNumber()));
                intent.putExtra("type",2);//type 2 means we are updating
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView orderimage;
        TextView orderItemName,orderNumber,textView9;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            orderimage=itemView.findViewById(R.id.orderimage);
            orderItemName=itemView.findViewById(R.id.orderItemName);

            textView9=itemView.findViewById(R.id.textView9);
            orderNumber=itemView.findViewById(R.id.orderNumber);
        }
    }
}
