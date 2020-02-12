package com.gmail.ivan.synopsis.ui.activity;

import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.contracts.ThesisListContract;
import com.gmail.ivan.synopsis.mvp.presenter.ThesisListPresenter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ThesisListActivity extends BaseActivity<ThesisListPresenter> implements ThesisListContract.View {

    @Override
    public void showThesisList(@Nullable List<Thesis> thesisList) {
        // TODO: 2/12/2020 will be created in another task 
    }

    @Override
    public void showEmptyThesisList() {
        // TODO: 2/12/2020 will be created in another task 
    }

    @NonNull
    @Override
    protected ThesisListPresenter createPresenter() {
        // TODO: 2/12/2020 will be created in another task 
        throw new UnsupportedOperationException();
    }

    @Override
    public int getLayoutRes() {
        // TODO: 2/12/2020 will be created in another task 
        return 0;
    }

    @Override
    public int getToolbarTitle() {
        // TODO: 2/12/2020 will be created in another task 
        return 0;
    }

    @Override
    public void showProgress() {
        // TODO: 2/12/2020 will be created in another task 
    }

    @Override
    public void hideProgress() {
        // TODO: 2/12/2020 will be created in another task 
    }
}
