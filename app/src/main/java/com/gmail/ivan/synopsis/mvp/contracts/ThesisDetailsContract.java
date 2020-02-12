package com.gmail.ivan.synopsis.mvp.contracts;

import com.gmail.ivan.synopsis.data.entity.Thesis;

import androidx.annotation.NonNull;

public interface ThesisDetailsContract {

    interface View extends BaseContract.View {

        void showThesis(@NonNull Thesis thesis);

        void emptyThesisName();

        void emptyThesisDescription();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void saveThesis();
    }

    interface Router extends BaseContract.Router {

    }
}
