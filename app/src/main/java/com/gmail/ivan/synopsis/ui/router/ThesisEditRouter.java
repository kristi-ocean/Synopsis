package com.gmail.ivan.synopsis.ui.router;

import android.content.Intent;

import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.contracts.ThesisEditContract;
import com.gmail.ivan.synopsis.ui.activity.BaseActivity;
import com.gmail.ivan.synopsis.ui.activity.ThesisPagerActivity;

import androidx.annotation.NonNull;

public class ThesisEditRouter implements ThesisEditContract.Router {

    @NonNull
    private final BaseActivity activity;

    public ThesisEditRouter(@NonNull BaseActivity activity) {
        this.activity = activity;
    }

    @Override
    public void back() {
        //none
    }

    @Override
    public void back(@NonNull Thesis thesis) {
        Intent intent =
                ThesisPagerActivity.newIntent(activity, thesis.getId(), thesis.getThemeName());

        activity.startActivity(intent);
    }
}
