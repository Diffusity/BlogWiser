package com.example.iser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;

public class login extends AppCompatActivity {

    MaterialButton login;
    EditText username,password;
    String oldusername,oldpassword,newpassword,newusername;
    int count=2;
    LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        login=findViewById(R.id.btn);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        oldusername=getIntent().getStringExtra("username");
        oldpassword=getIntent().getStringExtra("password");
        newusername=getIntent().getStringExtra("newusername");
        newpassword=getIntent().getStringExtra("newpassword");
        lottie=findViewById(R.id.lottie);
        lottie.playAnimation();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().length()==0){
                    username.requestFocus();
                    Toast toast= Toast.makeText(login.this,"User name can't be empty...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(password.getText().toString().length()==0){
                    password.requestFocus();
                    Toast toast= Toast.makeText(login.this,"Password can't be empty...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(username.getText().toString().equals(oldusername)&&password.getText().toString().equals(oldpassword)){
                    Intent intent=new Intent(login.this, home.class);
                    intent.putExtra("username",username.getText().toString());
                    startActivity(intent);
                }
                else if(!username.getText().toString().equals(newusername)&&password.getText().toString().equals(newpassword)){
                    Intent intent=new Intent(login.this, home.class);
                    intent.putExtra("username",username.getText().toString());
                    startActivity(intent);
                }
                else{
                    if(count==0){
                        Intent intent=new Intent(login.this, signup.class);
                        startActivity(intent);
                    }
                    Toast toast= Toast.makeText(login.this,"Please Sign Up...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                    count--;
                }
            }
        });
    }
}