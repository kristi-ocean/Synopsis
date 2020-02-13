package com.gmail.ivan.synopsis.ui.activity;

import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.contracts.ThesisPagerContract;
import com.gmail.ivan.synopsis.mvp.presenter.ThesisPagerPresenter;

import java.util.List;

import androidx.annotation.NonNull;

public class ThesisPagerActivity extends BaseActivity<ThesisPagerPresenter> implements ThesisPagerContract.View {

    @Override
    public void setThesisList(List<Thesis> thesisList) {
        // TODO: 2/13/2020 will ba created in another task
    }

    @NonNull
    @Override
    protected ThesisPagerPresenter createPresenter() {
        // TODO: 2/13/2020 will ba created in another task
        return null;
    }

    @Override
    public int getLayoutRes() {
        // TODO: 2/13/2020 will ba created in another task
        return 0;
    }

    @Override
    public String getToolbarTitle() {
        // TODO: 2/13/2020 will ba created in another task
        return null;
    }

    @Override
    public void showProgress() {
        // TODO: 2/13/2020 will ba created in another task
    }

    @Override
    public void hideProgress() {
        // TODO: 2/13/2020 will ba created in another task
    }
}
