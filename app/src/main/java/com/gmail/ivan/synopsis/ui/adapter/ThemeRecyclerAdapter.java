package com.gmail.ivan.synopsis.ui.adapter;

import android.view.View;

import com.gmail.ivan.synopsis.R;
import com.gmail.ivan.synopsis.data.entity.Theme;
import com.gmail.ivan.synopsis.mvp.presenter.ThemeListPresenter;

import androidx.annotation.NonNull;

public class ThemeRecyclerAdapter extends BaseRecyclerAdapter<Theme> {

    @NonNull
    private final ThemeListPresenter presenter;

    public ThemeRecyclerAdapter(@NonNull ThemeListPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected int getLayoutID() {
        return R.layout.theme_list_item;
    }

    @NonNull
    @Override
    protected BaseViewHolder<Theme> createHolder(@NonNull View view) {
        return new ThemeViewHolder(view, presenter);
    }

    @Override
    public void deleteItem(int position) {
        presenter.delete(getItem(position));
        presenter.loadThemeList();
    }
}
