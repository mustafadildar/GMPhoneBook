package com.example.gmphonebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button add,show,delete,edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       add=findViewById(R.id.btn_add);
       add.setOnClickListener(new View.OnClickListener() {
           @Override

           public void onClick(View v) {
            
               Intent in=new Intent(MainActivity.this,AddContact.class);
               startActivity(in);
           }
       });

       show=findViewById(R.id.btn_view);
       show.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent in=new Intent(MainActivity.this,ShowData.class);
               in.putExtra("Flag",0);
               startActivity(in);

           }
       });
       delete=findViewById(R.id.btn_del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(MainActivity.this,ShowData.class);
                in.putExtra("Flag",1);
                startActivity(in);

            }
        });
        edit=findViewById(R.id.btn_edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in=new Intent(MainActivity.this,ShowData.class);
                in.putExtra("Flag",2);
                startActivity(in);

            }
        });
    }
}