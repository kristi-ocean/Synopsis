package com.gmail.ivan.synopsis.mvp.contracts;

import com.gmail.ivan.synopsis.data.entity.Thesis;

import androidx.annotation.NonNull;

public interface ThesisDetailsContract {

    interface View extends BaseContract.View {

        void showThesis(@NonNull Thesis thesis);
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void loadThesis(@NonNull String thesisId);

        void saveThesis(@NonNull Thesis thesis);
    }

    interface Router extends BaseContract.Router {

    }
}
