package com.example.gmphonebook;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.io.File;


public class AddContact extends AppCompatActivity {
EditText fname,lname,ph,em;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        fname=findViewById(R.id.add_fname);
        lname=findViewById(R.id.add_lname);
        ph=findViewById(R.id.add_fone);
        em=findViewById(R.id.add_email);

        btn=findViewById(R.id.btn_add_contact);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                try {
               // SQLiteDatabase db;
               // db=SQLiteDatabase.openOrCreateDatabase("phonebook", null);
               SQLiteDatabase db=openOrCreateDatabase("phonebook", Context.MODE_PRIVATE,null);

                              db.execSQL("create table if not exists contacts(id integer primary key autoincrement, fname varchar,lname varchar, ph varchar, email varchar)");

                db.execSQL("insert into contacts(fname,lname,ph,email) values ('"+fname.getText().toString()+"','"+lname.getText().toString()+"','"+ph.getText().toString()+"','"+em.getText().toString()+"')");

               // db.close();
                Toast.makeText(AddContact.this,"Data Saved",Toast.LENGTH_SHORT).show();


                lname.setText("");
                ph.setText("");
                em.setText("");
                fname.setText("");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}