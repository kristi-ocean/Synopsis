package com.gmail.ivan.synopsis.mvp.contracts;

import androidx.annotation.NonNull;

import com.gmail.ivan.synopsis.data.entity.Theme;

public interface NewThemeDialogContract {

    interface View extends BaseContract.View {

        void emptyTheme();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void addTheme(@NonNull Theme theme);
    }

    interface Router extends BaseContract.Router {

    }
}
