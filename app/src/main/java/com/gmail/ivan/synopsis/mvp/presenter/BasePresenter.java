package com.gmail.ivan.synopsis.mvp.presenter;

import com.gmail.ivan.synopsis.mvp.contracts.BaseContract;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract class BasePresenter<V extends BaseContract.View, R extends BaseContract.Router>
        implements BaseContract.Presenter<V> {

    @Nullable
    private V view;

    @NonNull
    private final R router;

    public BasePresenter(@NonNull R router) {
        this.router = router;
    }

    @CallSuper
    @Override
    public void attach(@NonNull V view) {
        this.view = view;
    }

    @CallSuper
    @Override
    public void detach() {
        this.view = null;
    }

    @Override
    public void back() {
        router.back();
    }

    @Nullable
    @Override
    public V getView() {
        return view;
    }

    @NonNull
    public R getRouter() {
        return router;
    }
}
