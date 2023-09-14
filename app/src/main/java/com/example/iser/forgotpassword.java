package com.example.iser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.button.MaterialButton;

import java.util.regex.Pattern;

public class forgotpassword extends AppCompatActivity {

    MaterialButton setpassword;
    EditText username,newpassword,reenterpassword;
    String oldusername,oldpassword;
    LottieAnimationView lottie,lottie2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setpassword=findViewById(R.id.btn);
        username=findViewById(R.id.username);
        newpassword=findViewById(R.id.newpassword);
        reenterpassword=findViewById(R.id.reenterpassword);
        lottie=findViewById(R.id.lottie);
        lottie2=findViewById(R.id.lottie2);
        lottie.playAnimation();
        lottie2.playAnimation();
        oldusername=getIntent().getStringExtra("username");
        oldpassword=getIntent().getStringExtra("password");
        setpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().length()==0){
                    username.requestFocus();
                    Toast toast= Toast.makeText(forgotpassword.this,"User name can't be empty...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER| Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",newpassword.getText().toString())){
                    newpassword.requestFocus();
                    Toast toast= Toast.makeText(forgotpassword.this,"New Password is invalid...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(newpassword.getText().toString().length()==0){
                    newpassword.requestFocus();
                    Toast toast= Toast.makeText(forgotpassword.this,"New Password can't be empty...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(reenterpassword.getText().toString().length()==0){
                    reenterpassword.requestFocus();
                    Toast toast= Toast.makeText(forgotpassword.this,"Re-Enter Password can't be empty...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(!reenterpassword.getText().toString().equals(newpassword.getText().toString())){
                    reenterpassword.requestFocus();
                    Toast toast= Toast.makeText(forgotpassword.this,"Re - Enter Password must be same as New Password...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(newpassword.getText().toString().equals(oldpassword)){
                    newpassword.requestFocus();
                    Toast toast= Toast.makeText(forgotpassword.this,"Please enter valid New Password...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(!username.getText().toString().equals(oldusername)){
                    username.requestFocus();
                    Toast toast= Toast.makeText(forgotpassword.this,"Please enter valid User Name...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else{
                    Intent intent=new Intent(forgotpassword.this, intro2.class);
                    intent.putExtra("newusername",username.getText().toString());
                    intent.putExtra("newpassword",newpassword.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}