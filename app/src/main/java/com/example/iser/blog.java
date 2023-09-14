package com.example.iser;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

public class blog extends Fragment {

    new_blog new_blog;
    MaterialButton btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v=(ViewGroup) inflater.inflate(R.layout.fragment_blog, container, false);
        btn=v.findViewById(R.id.btn);
        new_blog=new new_blog();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction=getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.frame,new_blog,null).commit();
            }
        });
        return v;
    }
}