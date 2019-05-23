package com.example.dneprovdanila.stack_overflow_android;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.dneprovdanila.stack_overflow_android.POJO.Item;

import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Myholder> {


    List<Item> list;

    public RecyclerAdapter(ArrayList<Item> list) {
        this.list = list;
    }


    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_field, parent, false);
        Myholder myHolder = new Myholder(view);
        return myHolder;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public void onBindViewHolder(Myholder holder, int position) {

        Item item = list.get(position);
        holder.textView_title.setText(item.getTitle());
        holder.textView_number.setText(Integer.toString(++position));
    }


    public class Myholder extends RecyclerView.ViewHolder {
        TextView textView_title, textView_number;

        public Myholder(View itemView) {
            super(itemView);

            textView_title = (TextView) itemView.findViewById(R.id.textView_title);
            textView_number = (TextView) itemView.findViewById(R.id.textView_number);
        }
    }
}
/*

public class RecyclerAdapter {




}
*/
