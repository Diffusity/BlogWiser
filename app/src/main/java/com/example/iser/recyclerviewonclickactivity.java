package com.example.iser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class recyclerviewonclickactivity extends AppCompatActivity {

    ImageView image;
    TextView title,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerviewonclickactivity);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        image=findViewById(R.id.image);
        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        image.setImageResource(getIntent().getIntExtra("Image",R.drawable.img1));
        title.setText(getIntent().getStringExtra("Title"));
        description.setText(getIntent().getStringExtra("Description"));
    }
}