package com.gmail.ivan.synopsis.mvp.contracts;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface BaseContract {

    interface View {

        void onError(@Nullable Throwable error);

        void showProgress();

        void hideProgress();
    }

    interface Presenter<V extends View> {

        void attach(@NonNull V view);

        void detach();

        void back();

        @Nullable
        V getView();
    }

    interface Router {

        void back();
    }
}
