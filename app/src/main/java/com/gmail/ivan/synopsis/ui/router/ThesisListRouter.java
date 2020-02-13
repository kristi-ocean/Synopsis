package com.gmail.ivan.synopsis.ui.router;

import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.contracts.ThesisListContract;
import com.gmail.ivan.synopsis.ui.activity.BaseActivity;

import androidx.annotation.NonNull;

public class ThesisListRouter implements ThesisListContract.Router {

    @NonNull
    private final BaseActivity activity;

    public ThesisListRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void openThesis(@NonNull Thesis thesis) {
        // TODO: 2/12/2020 will be created in another task
    }

    @Override
    public void back() {
        activity.finish();
    }
}
