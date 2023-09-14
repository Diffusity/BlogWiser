package com.example.iser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;

public class intro2 extends AppCompatActivity {

    MaterialButton login,signup,forgotpassword;
    String username,password,newusername,newpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        forgotpassword=findViewById(R.id.forgot);
        username=getIntent().getStringExtra("username");
        password=getIntent().getStringExtra("password");
        newusername=getIntent().getStringExtra("newusername");
        newpassword=getIntent().getStringExtra("newpassword");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(intro2.this,login.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                intent.putExtra("newusername",newusername);
                intent.putExtra("newpassword",newpassword);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(intro2.this,signup.class);
                startActivity(intent);
            }
        });
        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(intro2.this,forgotpassword.class);
                intent.putExtra("username",username);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
        ImageView btn=findViewById(R.id.image);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), home.class);
                startActivity(intent);
            }
        });
    }
}