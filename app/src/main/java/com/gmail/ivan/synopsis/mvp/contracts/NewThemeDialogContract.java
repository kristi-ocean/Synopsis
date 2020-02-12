package com.gmail.ivan.synopsis.mvp.contracts;

import androidx.annotation.NonNull;

public interface NewThemeDialogContract {

    interface View extends BaseContract.View {

        void emptyTheme();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void addTheme(@NonNull String themeName);
    }

    interface Router extends BaseContract.Router {

    }
}
