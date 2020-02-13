package com.gmail.ivan.synopsis.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gmail.ivan.synopsis.R;
import com.gmail.ivan.synopsis.data.database.AppDataBaseSingleton;
import com.gmail.ivan.synopsis.data.entity.Theme;
import com.gmail.ivan.synopsis.mvp.contracts.ThemeListContract;
import com.gmail.ivan.synopsis.mvp.presenter.ThemeListPresenter;
import com.gmail.ivan.synopsis.ui.adapter.SwipeToDeleteCallback;
import com.gmail.ivan.synopsis.ui.adapter.ThemeRecyclerAdapter;
import com.gmail.ivan.synopsis.ui.fragment.BaseDialog;
import com.gmail.ivan.synopsis.ui.fragment.NewThemeDialog;
import com.gmail.ivan.synopsis.ui.router.ThemeListRouter;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ThemeListActivity extends BaseActivity<ThemeListPresenter> implements
                                                                        ThemeListContract.View,
                                                                        NewThemeDialog.NewThemeDialogListener {

    @Nullable
    private ProgressBar progressBar;

    @Nullable
    private TextView emptyListText;

    @Nullable
    private RecyclerView recyclerView;

    @Nullable
    private ThemeRecyclerAdapter recyclerAdapter;

    @NonNull
    @Override
    protected ThemeListPresenter createPresenter() {
        ThemeListRouter router = new ThemeListRouter(this);
        return new ThemeListPresenter(router,
                                      AppDataBaseSingleton.get(this)
                                                          .getDataBase());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        progressBar = findViewById(R.id.progress_bar);

        emptyListText = findViewById(R.id.empty_list_text);

        recyclerView = findViewById(R.id.theme_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new ThemeRecyclerAdapter(getPresenter());
        recyclerView.setAdapter(recyclerAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(recyclerAdapter));
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.theme_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_theme:
                getPresenter().newTheme();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().loadThemeList();
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_theme_list;
    }

    @Override
    public int getToolbarTitle() {
        return R.string.app_name;
    }

    @Override
    public void showThemeList(@Nullable List<Theme> themeList) {
        Objects.requireNonNull(recyclerAdapter)
               .setEntityListData(themeList);
        Objects.requireNonNull(emptyListText)
               .setVisibility(View.GONE);
    }

    @Override
    public void showEmptyList() {
        Objects.requireNonNull(emptyListText)
               .setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress() {
        Objects.requireNonNull(progressBar)
               .setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        Objects.requireNonNull(progressBar)
               .setVisibility(View.GONE);
    }

    @Override
    public void onDialogPositiveClick(@NonNull BaseDialog dialog) {
        getPresenter().loadThemeList();
    }
}
