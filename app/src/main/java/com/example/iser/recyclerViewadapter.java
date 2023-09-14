package com.example.iser;

import static androidx.recyclerview.widget.RecyclerView.NO_POSITION;

import android.content.Context;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class recyclerViewadapter extends RecyclerView.Adapter<recyclerViewadapter.viewHolder> {

    Context context;
    ArrayList<modal> arrayList;
    recyclerviewinterfac recyclerviewinterfac;
    public recyclerViewadapter(Context context,ArrayList<modal> arrayList,recyclerviewinterfac recyclerviewinterfac){
        this.context=context;
        this.arrayList=arrayList;
        this.recyclerviewinterfac=recyclerviewinterfac;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.recyclerview_view,parent,false);
        viewHolder viewHolder=new viewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.text.setText(arrayList.get(position).text);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        MaterialButton btn;
        TextView text;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.text);
            btn=itemView.findViewById(R.id.btn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerviewinterfac!=null){
                        int position=getAdapterPosition();
                        if(position!=NO_POSITION){
                            recyclerviewinterfac.onitemClicked(position);
                        }
                    }
                }
            });
        }
    }
}
