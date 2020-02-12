package com.gmail.ivan.synopsis.mvp.presenter;

import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.contracts.ThesisListContract;

import androidx.annotation.NonNull;

public class ThesisListPresenter extends BasePresenter<ThesisListContract.View, ThesisListContract.Router> implements ThesisListContract.Presenter {

    public ThesisListPresenter(@NonNull ThesisListContract.Router router) {
        super(router);
    }

    @Override
    public void loadThesisList() {
        // TODO: 2/12/2020 will be created in another task
    }

    @Override
    public void showThesisList() {
        // TODO: 2/12/2020 will be created in another task
    }

    @Override
    public void newThesis() {
        // TODO: 2/12/2020 will be created in another task
    }

    @Override
    public void openThesis(@NonNull Thesis thesis) {
        // TODO: 2/12/2020 will be created in another task
    }

    @Override
    public void deleteThesis(@NonNull Thesis thesis) {
        // TODO: 2/12/2020 will be created in another task
    }
}
