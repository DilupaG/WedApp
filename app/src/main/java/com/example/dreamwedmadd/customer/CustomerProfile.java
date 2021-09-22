package com.example.dreamwedmadd.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dreamwedmadd.LoginActivity;
import com.example.dreamwedmadd.R;
import com.example.dreamwedmadd.database.DBConnection;

public class CustomerProfile extends AppCompatActivity {

    Button button,btndel;
    EditText etname,etemail,etmobile;
    DBConnection db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        //mapping
        button=findViewById(R.id.userprofubtn);
        btndel=findViewById(R.id.userdeleteubtn);
        etname=findViewById(R.id.userprofname);
        etemail=findViewById(R.id.userprofemail);
        etmobile=findViewById(R.id.userprofphone);

        db=new DBConnection(getApplicationContext());

        //event handling for going to profile update
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= etname.getText().toString();
                String email=etemail.getText().toString();
                String mobile=etmobile.getText().toString();

                 //intent creation: Explicit
                    Intent i = new Intent(CustomerProfile.this, CustomerProfileUD.class);
                    i.putExtra("Name",username);
                    i.putExtra("Email",email);
                    i.putExtra("Mobile",mobile);
                    Toast.makeText(CustomerProfile.this,"Directing to Profile Update",Toast.LENGTH_LONG).show();
                    startActivity(i);
            }
        });

        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=etemail.getText().toString();
                db.deleteUser(email);

                Intent i = new Intent(CustomerProfile.this, LoginActivity.class);
                Toast.makeText(CustomerProfile.this,"User deleted",Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

    }
}