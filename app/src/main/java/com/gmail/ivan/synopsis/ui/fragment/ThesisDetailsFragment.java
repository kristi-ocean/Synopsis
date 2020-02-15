package com.gmail.ivan.synopsis.ui.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.gmail.ivan.synopsis.R;
import com.gmail.ivan.synopsis.data.database.AppDataBaseSingleton;
import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.contracts.ThesisDetailsContract;
import com.gmail.ivan.synopsis.mvp.presenter.ThesisDetailsPresenter;
import com.gmail.ivan.synopsis.ui.router.ThesisDetailsRouter;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ThesisDetailsFragment extends BaseFragment<ThesisDetailsPresenter>
        implements ThesisDetailsContract.View {

    private static final String THESIS_ID = "thesis_id";

    @Nullable
    private EditText thesisTitle;

    @Nullable
    private EditText thesisDescription;

    @Nullable
    private Thesis thesis;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        thesisTitle = view.findViewById(R.id.thesis_title);
        thesisTitle.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("OLOLO", "onTextChanged: " + (thesis == null));
                Objects.requireNonNull(thesis)
                       .setThesisName(charSequence.toString());
                getPresenter().saveThesis(thesis);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        thesisDescription = view.findViewById(R.id.thesis_details_description);
        thesisDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Objects.requireNonNull(thesis)
                       .setThesisDescription(charSequence.toString());
                getPresenter().saveThesis(thesis);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        getPresenter().loadThesis(Objects.requireNonNull(Objects.requireNonNull(getArguments())
                                                                .getString(THESIS_ID)));
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

    public static ThesisDetailsFragment newInstance(@NonNull String thesisId) {

        Bundle args = new Bundle();
        args.putString(THESIS_ID, thesisId);

        ThesisDetailsFragment fragment = new ThesisDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
