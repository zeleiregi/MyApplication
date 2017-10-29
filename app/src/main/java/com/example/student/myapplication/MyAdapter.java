package com.example.student.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2017. 10. 28..
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> data = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ElementViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_element, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ElementViewHolder evh = (ElementViewHolder) holder;
        evh.title.setText(data.get(position));
    }

    public void onBindViewHolder(RecyclerView holder, int position) {

    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    private class ElementViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ElementViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.elementTitle);
        }
    }
}
