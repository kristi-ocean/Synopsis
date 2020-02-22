package com.gmail.ivan.synopsis.ui.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gmail.ivan.synopsis.R;
import com.gmail.ivan.synopsis.data.database.AppDataBaseSingleton;
import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.contracts.ThesisDetailsContract;
import com.gmail.ivan.synopsis.mvp.presenter.ThesisDetailsPresenter;
import com.gmail.ivan.synopsis.ui.router.ThesisDetailsRouter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ThesisDetailsFragment extends BaseFragment<ThesisDetailsPresenter>
        implements ThesisDetailsContract.View {

    private static final String THESIS_ID = "thesis_id";

    @Nullable
    private TextView thesisTitle;

    @Nullable
    private TextView thesisDescription;

    @Nullable
    private FloatingActionButton editFab;

    @Nullable
    private Thesis thesis;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        thesisTitle = view.findViewById(R.id.thesis_title);

        thesisDescription = view.findViewById(R.id.thesis_details_description);

        editFab = view.findViewById(R.id.edit_thesis_fab);
        editFab.setOnClickListener(v -> {
            getPresenter().showEditThesis(Objects.requireNonNull(thesis));
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        getPresenter().loadThesis(Objects.requireNonNull(getArguments())
                                         .getInt(THESIS_ID));
    }

    @Override
    public void showThesis(@NonNull Thesis thesis) {
        this.thesis = thesis;
        Objects.requireNonNull(thesisTitle)
               .setText(thesis.getThesisName());
        Objects.requireNonNull(thesisDescription)
               .setText(thesis.getThesisDescription());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_thesis_details;
    }

    @NonNull
    @Override
    protected ThesisDetailsPresenter createPresenter() {
        ThesisDetailsRouter router = new ThesisDetailsRouter(requireBaseActivity());
        ThesisDetailsPresenter presenter = new ThesisDetailsPresenter(router,
                                                                      AppDataBaseSingleton.get(
                                                                              requireContext())
                                                                                          .getDataBase());
        return presenter;
    }

    public static ThesisDetailsFragment newInstance(int thesisId) {

        Bundle args = new Bundle();
        args.putInt(THESIS_ID, thesisId);

        ThesisDetailsFragment fragment = new ThesisDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
