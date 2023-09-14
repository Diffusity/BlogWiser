package com.example.iser;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.google.android.material.button.MaterialButton;

import java.util.regex.Pattern;

public class new_blog extends Fragment {

    sentdatalistener listener;
    MaterialButton btn;
    EditText title,description;
    int count=0;
    FrameLayout frame1;
    public interface sentdatalistener{
        void oninputSent(String title,String description);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v=(ViewGroup) inflater.inflate(R.layout.fragment_new_blog, container, false);
        title=v.findViewById(R.id.title);
        description=v.findViewById(R.id.description);
        btn=v.findViewById(R.id.btn);
        blog blog=new blog();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(title.getText().toString().length()==0){
                    title.requestFocus();
                    Toast toast=Toast.makeText(getContext(),"Title can't be empty...!",LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else if(description.getText().toString().length()==0){
                    description.requestFocus();
                    Toast toast= Toast.makeText(getContext(),"Description can't be empty...!", LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                    toast.show();
                }
                else{
                    if(count==0){
                        listener.oninputSent(title.getText().toString(),description.getText().toString());
                        count++;
                        Toast toast= Toast.makeText(getContext(),"Posted",LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                        toast.show();
                        FragmentTransaction transaction=getChildFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame1,blog,null).commit();
                    }
                    else{
                        Toast toast= Toast.makeText(getContext(),"Already Posted! Check explore page..!",LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER|Gravity.BOTTOM,0,0);
                        toast.show();
                    }
                }
            }
        });
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof sentdatalistener){
            listener=(sentdatalistener) context;
        }
        else{
            throw new RuntimeException(context.toString()+"must implement sentdatalistener");
        }
    }
}