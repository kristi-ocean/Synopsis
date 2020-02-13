package com.gmail.ivan.synopsis.mvp.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.gmail.ivan.synopsis.data.database.AppDataBase;
import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.contracts.ThesisListContract;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;

public class ThesisListPresenter
        extends BasePresenter<ThesisListContract.View, ThesisListContract.Router>
        implements ThesisListContract.Presenter {

    private static final String TAG = ThesisListPresenter.class.getSimpleName();

    @NonNull
    private final AppDataBase dataBase;

    @NonNull
    private final String themeName;

    public ThesisListPresenter(@NonNull ThesisListContract.Router router,
                               @NonNull AppDataBase dataBase,
                               @NonNull String themeName) {
        super(router);

        this.dataBase = dataBase;
        this.themeName = themeName;
    }

    @Override
    public void loadThesisList() {
        try {
            List<Thesis> thesisList = new LoadThesisListTask(dataBase).execute(themeName)
                                                                      .get();
            if (thesisList.isEmpty()) {
                Objects.requireNonNull(getView())
                       .showEmptyThesisList();
            } else {
                assert getView() != null;
                getView().showThesisList(thesisList);
            }
        } catch (ExecutionException e) {
            Log.e(TAG, "loadThesisList: ", e);
        } catch (InterruptedException e) {
            Log.e(TAG, "loadThesisList: ", e);
        }
    }

    @Override
    public void newThesis() {
        // TODO: 2/12/2020 will be created in another task
    }

    @Override
    public void openThesis(@NonNull Thesis thesis) {
        // TODO: 2/12/2020 will be created in another task
    }

    @Override
    public void deleteThesis(@NonNull Thesis thesis) {
        // TODO: 2/12/2020 will be created in another task
    }

    private static class LoadThesisListTask extends AsyncTask<String, Void, List<Thesis>> {

        @NonNull
        private final AppDataBase dataBase;

        public LoadThesisListTask(@NonNull AppDataBase dataBase) {
            this.dataBase = dataBase;
        }

        @Override
        protected List<Thesis> doInBackground(String... strings) {
            return dataBase.thesisRepository()
                           .getThesisList(strings[0]);
        }
    }
}
