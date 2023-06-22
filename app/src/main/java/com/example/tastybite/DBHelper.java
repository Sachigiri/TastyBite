package com.example.tastybite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tastybite.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    final static String DBNAME="mydatabase.db";
    final static int DBVERSION=1;
    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//this method is to create our table
sqLiteDatabase.execSQL(
        "create table orders "+
                "(id integer primary key autoincrement,"+
                "name text,"+
                "phone text,"+
                "quantity int,"+
                "price int,"+
                "image int,"+
                "description text,"+
                "foodname text)"
);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {//yha pe agar 100 times table mai chnages ki hai to 100 times table del hoga or new table banega
      sqLiteDatabase.execSQL("DROP table if exists orders");//to del the old table everytime
      onCreate(sqLiteDatabase);//to create new table evrytime
    }//SQLiteOpenHelper ye abstract class hai to iske methods ko implement karna hoga
    public boolean insertOrder(String name,String phone,int price,int image,String description,String foodname,int quantity)//this method is used to insert our data in the table
    {
        SQLiteDatabase database=getReadableDatabase();//helps to read the data that we have created
        ContentValues value=new ContentValues();//it is like a hashmap
        value.put("name",name);//key ka naam column ka naam hoga
        value.put("phone",phone);
        value.put("price",price);
        value.put("image",image);
        value.put("description",description);
        value.put("foodname",foodname);
        value.put("quantity",quantity);
        long id=database.insert("orders",null,value);//this insert will return a long type id  if data will get added in the table else will return 0 or -1.
        if(id<=0)
        {
            return false;
        }
        else
        {
            return true;
        }


    }
    public ArrayList<OrdersModel> getOrders()
    {
ArrayList<OrdersModel>orders=new ArrayList<>();
SQLiteDatabase  database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select id,foodname,image,price from orders",null);//cursor is a pointer jo row by row chlta hai
//        if(cursor.moveToFirst())
//        {
//            while(cursor.moveToNext())
//            {
//              OrdersModel model=new OrdersModel();
//                model.setOrderNumber(cursor.getInt(0)+"");
//                model.setSoldItemName(cursor.getString(1));
//                model.setOrderImage(cursor.getInt(2));
//                model.setPrice(cursor.getInt(3)+"");
//                orders.add(model);
//            }
//        }
        if(cursor.moveToFirst())
        {
            do
            {
                OrdersModel model=new OrdersModel();
                model.setOrderNumber(cursor.getInt(0)+"");
                model.setOrderItemName(cursor.getString(1));
                model.setOrderimage(cursor.getInt(2));
                model.setTextView9(cursor.getInt(3)+"");
                orders.add(model);
            }while(cursor.moveToNext());
        }
        cursor.close();
        database.close();
        return orders;
    }
    public Cursor getOrderById(int id)
    {
       // ArrayList<OrdersModel>orders=new ArrayList<>();
        SQLiteDatabase  database=this.getWritableDatabase();
        Cursor cursor=database.rawQuery("Select from orders where id="+ id,null);//cursor is a pointer jo row by row chlta hai
//        if(cursor.moveToFirst())
//        {
//            while(cursor.moveToNext())
//            {
//              OrdersModel model=new OrdersModel();
//                model.setOrderNumber(cursor.getInt(0)+"");
//                model.setSoldItemName(cursor.getString(1));
//                model.setOrderImage(cursor.getInt(2));
//                model.setPrice(cursor.getInt(3)+"");
//                orders.add(model);
//            }
//        }
        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

//        cursor.close();
//        database.close();
        return cursor;
    }

}
