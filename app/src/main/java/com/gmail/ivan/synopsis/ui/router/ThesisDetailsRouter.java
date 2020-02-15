package com.gmail.ivan.synopsis.ui.router;

import com.gmail.ivan.synopsis.mvp.contracts.ThesisDetailsContract;
import com.gmail.ivan.synopsis.ui.activity.BaseActivity;

import androidx.annotation.NonNull;

public class ThesisDetailsRouter implements ThesisDetailsContract.Router {

    @NonNull
    private final BaseActivity activity;

    public ThesisDetailsRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void back() {
        activity.finish();
    }
}
