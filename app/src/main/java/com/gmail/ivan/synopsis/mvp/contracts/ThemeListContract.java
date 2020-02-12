package com.gmail.ivan.synopsis.mvp.contracts;

import com.gmail.ivan.synopsis.data.entity.Theme;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public interface ThemeListContract {

    interface View extends BaseContract.View {

        void showThemeList(@Nullable List<Theme> themeList);

        void showEmptyList();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void loadThemeList();

        void newTheme();

        void openTheme(@NonNull Theme theme);

        void delete(@NonNull Theme theme);
    }

    interface Router extends BaseContract.Router {

        void openTheme(@NonNull Theme theme);

        void openNewTheme();
    }
}
