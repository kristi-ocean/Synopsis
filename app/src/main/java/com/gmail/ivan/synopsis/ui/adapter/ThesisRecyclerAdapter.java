package com.gmail.ivan.synopsis.ui.adapter;

import android.view.View;

import com.gmail.ivan.synopsis.R;
import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.presenter.ThesisListPresenter;

import androidx.annotation.NonNull;

public class ThesisRecyclerAdapter extends BaseRecyclerAdapter<Thesis> {

    @NonNull
    private final ThesisListPresenter presenter;

    public ThesisRecyclerAdapter(@NonNull ThesisListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.thesis_list_item;
    }

    @NonNull
    @Override
    protected BaseViewHolder<Thesis> createHolder(@NonNull View view) {
        return new ThesisViewHolder(view, presenter);
    }

    @Override
    public void deleteItem(int position) {
        presenter.deleteThesis(getItem(position));
        presenter.loadThesisList();
    }
}
