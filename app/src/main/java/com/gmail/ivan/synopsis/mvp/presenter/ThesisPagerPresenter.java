package com.gmail.ivan.synopsis.mvp.presenter;

import com.gmail.ivan.synopsis.mvp.contracts.ThesisPagerContract;

import androidx.annotation.NonNull;

public class ThesisPagerPresenter extends BasePresenter<ThesisPagerContract.View, ThesisPagerContract.Router> implements ThesisPagerContract.Presenter {

    public ThesisPagerPresenter(@NonNull ThesisPagerContract.Router router) {
        super(router);
        // TODO: 2/13/2020 will ba created in another task
    }

    @Override
    public void loadThesisList() {
        // TODO: 2/13/2020 will ba created in another task
    }
}
