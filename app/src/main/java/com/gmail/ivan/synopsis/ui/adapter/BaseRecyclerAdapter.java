package com.gmail.ivan.synopsis.ui.adapter;

import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseRecyclerAdapter<E> extends RecyclerView.Adapter<BaseViewHolder<E>> {

    @NonNull
    private List<E> entityList = new ArrayList<>();

    public void setEntityListData(List<E> entityList){
        this.entityList.clear();
        this.entityList.addAll(entityList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder<E> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return createHolder();
    }

    @NonNull
    protected abstract BaseViewHolder<E> createHolder();

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<E> holder, int position) {
        holder.bind(entityList.get(position));
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }
}
