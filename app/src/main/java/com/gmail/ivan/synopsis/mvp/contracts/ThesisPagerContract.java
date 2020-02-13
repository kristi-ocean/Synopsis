package com.gmail.ivan.synopsis.mvp.contracts;

import com.gmail.ivan.synopsis.data.entity.Thesis;

import java.util.List;

public interface ThesisPagerContract {

    interface View extends BaseContract.View {

        void setThesisList(List<Thesis> thesisList);
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void loadThesisList();
    }

    interface Router extends BaseContract.Router {

    }
}
