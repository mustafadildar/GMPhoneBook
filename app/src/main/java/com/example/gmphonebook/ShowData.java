package com.example.gmphonebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> dataholder;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        recyclerView= findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=getalldata();
        dataholder=new ArrayList<model>();
while(cursor.moveToNext())
{
    model obj=new model(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
            cursor.getString(3),cursor.getString(4));
    dataholder.add(obj);
}

MyAdapter adapter=new MyAdapter(dataholder);
recyclerView.setAdapter(adapter);
 Bundle bundle = getIntent().getExtras();

  if(bundle.getInt("Flag")== 1) {
      Toast.makeText(ShowData.this,"1",Toast.LENGTH_SHORT).show();
             new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT ) {
                 @Override
                 public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                     return false;
                 }

                 @Override
                 public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                     removeItem((Integer) viewHolder.itemView.getTag());
                 }
             }).attachToRecyclerView(recyclerView);
         }
   if(bundle.getInt("Flag")== 2 ) {


      new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,  ItemTouchHelper.LEFT) {
          @Override
          public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
              return false;
          }

          @Override
          public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

  editItem((Integer) viewHolder.itemView.getTag());

         }
      }).attachToRecyclerView(recyclerView);
         }

    }
    public Cursor getalldata(){

        SQLiteDatabase db=openOrCreateDatabase("phonebook", Context.MODE_PRIVATE,null);

        String qry="select * from contacts order by id desc";
        Cursor cursor=db.rawQuery(qry,null);



      return cursor;

    }

    private void removeItem(Integer id){

        SQLiteDatabase db=openOrCreateDatabase("phonebook", Context.MODE_PRIVATE,null);
        db.execSQL("delete from contacts where id="+id);
        Toast.makeText(ShowData.this,"Data Deleted",Toast.LENGTH_SHORT).show();

    }
    private void editItem(Integer id){
int id2=id;

        Intent in=new Intent(ShowData.this,EditContact.class);
        in.putExtra("ID", id2);
        startActivity(in);


    }
}