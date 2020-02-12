package com.gmail.ivan.synopsis.mvp.contracts;

import com.gmail.ivan.synopsis.data.entity.Thesis;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface ThesisListContract {

    interface View extends BaseContract.View {

        void showThesisList(@Nullable List<Thesis> thesisList);

        void showEmptyThesisList();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void loadThesisList();

        void showThesisList();

        void newThesis();

        void openThesis(@NonNull Thesis thesis);

        void deleteThesis(@NonNull Thesis thesis);
    }

    interface Router extends BaseContract.Router {

        void openThesis(@NonNull Thesis thesis);
    }
}
