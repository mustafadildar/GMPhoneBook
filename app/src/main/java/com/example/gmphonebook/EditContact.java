package com.example.gmphonebook;

import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditContact extends AppCompatActivity {
    EditText fname,lname,ph,em;
    Button btn;
    Integer id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        fname=findViewById(R.id.edit_fname);
        lname=findViewById(R.id.edit_lname);
        ph=findViewById(R.id.edit_fone);
        em=findViewById(R.id.edit_email);

        btn=findViewById(R.id.btn_edit_contact);
        Bundle bundle = getIntent().getExtras();
        if (bundle!= null) {// to avoid the NullPointerException
            Toast.makeText(EditContact.this,"Bundle  "+id,Toast.LENGTH_SHORT).show();
            id = bundle.getInt("ID");
        }
       // Toast.makeText(EditContact.this,"ID  "+id,Toast.LENGTH_SHORT).show();
        SQLiteDatabase db=openOrCreateDatabase("phonebook", Context.MODE_PRIVATE,null);

        String qry="select * from contacts where id="+id;
        Cursor cursor=db.rawQuery(qry,null);

        while(cursor.moveToNext()) {
            Toast.makeText(EditContact.this,"Move  ",Toast.LENGTH_SHORT).show();
            fname.setText(cursor.getString(1));
            lname.setText(cursor.getString(2));
            ph.setText(cursor.getString(3));
            em.setText(cursor.getString(4));
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {



                     String q="update contacts set fname='"+fname.getText().toString()+"', lname='"+lname.getText().toString()+"', ph='"+ph.getText().toString()+"', email='"+em.getText().toString()
                             +"' where id="+id;
                    SQLiteDatabase db=openOrCreateDatabase("phonebook", Context.MODE_PRIVATE,null);
                    db.execSQL(q);
                    // db.close();
                    Toast.makeText(EditContact.this,"Data Saved",Toast.LENGTH_SHORT).show();

                Intent in=new Intent(EditContact.this,ShowData.class);
                in.putExtra("Flag",2);
                startActivity(in);





            }
        });
    }
}