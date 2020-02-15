package com.gmail.ivan.synopsis.mvp.presenter;

import android.os.AsyncTask;
import android.util.Log;

import com.gmail.ivan.synopsis.data.database.AppDataBase;
import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.contracts.ThesisDetailsContract;

import java.util.Objects;
import java.util.concurrent.ExecutionException;

import androidx.annotation.NonNull;

public class ThesisDetailsPresenter
        extends BasePresenter<ThesisDetailsContract.View, ThesisDetailsContract.Router>
        implements ThesisDetailsContract.Presenter {

    private static final String TAG = ThesisDetailsPresenter.class.getSimpleName();

    @NonNull
    private final AppDataBase dataBase;

    public ThesisDetailsPresenter(@NonNull ThesisDetailsContract.Router router,
                                  @NonNull AppDataBase dataBase) {
        super(router);
        this.dataBase = dataBase;
    }

    @Override
    public void loadThesis(@NonNull String thesisId) {
        try {
            Thesis thesis = new LoadThesisTask(dataBase).execute(thesisId).get();
            Objects.requireNonNull(getView())
                   .showThesis(thesis);
        } catch (ExecutionException e) {
            Log.e(TAG, "loadThesis: ", e);
        } catch (InterruptedException e) {
            Log.e(TAG, "loadThesis: ", e);
        }
    }

    @Override
    public void saveThesis(@NonNull Thesis thesis) {
        new UpdateThesisTask(dataBase).execute(thesis);
    }

    private static class UpdateThesisTask extends AsyncTask<Thesis, Void, Void>{

        @NonNull
        private final AppDataBase dataBase;

        public UpdateThesisTask(@NonNull AppDataBase dataBase) {
            this.dataBase = dataBase;
        }

        @Override
        protected Void doInBackground(Thesis... theses) {
            dataBase.thesisRepository().updateThesis(theses[0]);
            return null;
        }
    }

    private static class LoadThesisTask extends AsyncTask<String, Void, Thesis>{

        @NonNull
        private final AppDataBase dataBase;

        public LoadThesisTask(@NonNull AppDataBase dataBase) {
            this.dataBase = dataBase;
        }

        @Override
        protected Thesis doInBackground(String... strings) {
            return dataBase.thesisRepository().getThesis(strings[0]);
        }
    }
}
