package com.gmail.ivan.synopsis.mvp.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.gmail.ivan.synopsis.data.database.AppDataBase;
import com.gmail.ivan.synopsis.data.entity.Theme;
import com.gmail.ivan.synopsis.mvp.contracts.ThemeListContract;
import com.gmail.ivan.synopsis.ui.router.ThemeListRouter;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;

public class ThemeListPresenter
        extends BasePresenter<ThemeListContract.View, ThemeListContract.Router> implements
                                                                                ThemeListContract.Presenter {

    private static final String TAG = ThemeListPresenter.class.getSimpleName();

    @NonNull
    private final AppDataBase dataBase;

    public ThemeListPresenter(@NonNull ThemeListRouter router, @NonNull AppDataBase dataBase) {
        super(router);

        this.dataBase = dataBase;
    }

    @Override
    public void loadThemeList() {
        try {
            List<Theme> themeList = new LoadThemeListTask(dataBase).execute()
                                                                   .get();
            if (themeList.isEmpty()) {
                Objects.requireNonNull(getView())
                       .showEmptyList();
            } else {
                Objects.requireNonNull(getView())
                       .showThemeList(themeList);
            }
        } catch (ExecutionException e) {
            Log.e(TAG, "loadThemeList: ", e);
        } catch (InterruptedException e) {
            Log.e(TAG, "loadThemeList: ", e);
        }
    }

    @Override
    public void newTheme() {
        getRouter().openNewTheme();
    }

    @Override
    public void openTheme(@NonNull Theme theme) {
        getRouter().openTheme(theme);
    }

    @Override
    public void delete(@NonNull Theme theme) {
        // TODO: 2/12/2020 Will Be created in another task
    }

    private static class LoadThemeListTask extends AsyncTask<Void, Void, List<Theme>> {

        @NonNull
        private final AppDataBase dataBase;

        public LoadThemeListTask(@NonNull AppDataBase dataBase) {
            this.dataBase = dataBase;
        }

        @Override
        protected List<Theme> doInBackground(Void... voids) {
            List<Theme> themeList = dataBase.themeRepository()
                                            .getAllThemes();

            for (Theme theme : themeList) {
                theme.setThesisCount(dataBase.thesisRepository()
                                             .getThesisList(theme.getThemeName())
                                             .size());
            }

            return themeList;
        }
    }
}
