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

public class signup extends AppCompatActivity {

    MaterialButton signup;
    EditText username,email,password;
    LottieAnimationView lottie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        signup=findViewById(R.id.btn);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        lottie=findViewById(R.id.lottie);
        lottie.playAnimation();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().length()==0){
                    username.requestFocus();
                    Toast toast= Toast.makeText(signup.this,"User name can't be empty...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(!Pattern.matches("^[a-zA-Z0-9_]{3,20}$",username.getText().toString())){
                    username.requestFocus();
                    Toast toast= Toast.makeText(signup.this,"User name must be 3-20 characters long...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(!Pattern.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}",email.getText().toString())){
                    email.requestFocus();
                    Toast toast= Toast.makeText(signup.this,"E - Mail is invalid...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(!Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",password.getText().toString())){
                    password.requestFocus();
                    Toast toast= Toast.makeText(signup.this,"Password is invalid...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(email.getText().toString().length()==0){
                    email.requestFocus();
                    Toast toast= Toast.makeText(signup.this,"E - Mail can't be empty...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(password.getText().toString().length()==0){
                    password.requestFocus();
                    Toast toast= Toast.makeText(signup.this,"Password can't be empty...!",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else{
                    Intent intent=new Intent(signup.this,intro2.class);
                    intent.putExtra("username",username.getText().toString());
                    intent.putExtra("password",password.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}