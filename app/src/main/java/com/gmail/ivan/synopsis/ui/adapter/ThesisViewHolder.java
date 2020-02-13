package com.gmail.ivan.synopsis.ui.adapter;

import android.view.View;
import android.widget.TextView;

import com.gmail.ivan.synopsis.R;
import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.mvp.presenter.ThesisListPresenter;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ThesisViewHolder extends BaseViewHolder<Thesis> implements View.OnClickListener {

    public static final int DEST_STR_LENGTH = 50;

    @NonNull
    private final TextView thesisName;

    @NonNull
    private final TextView thesisDescription;

    @Nullable
    private Thesis thesis;

    @NonNull
    private final ThesisListPresenter presenter;

    public ThesisViewHolder(@NonNull View itemView, @NonNull ThesisListPresenter presenter) {
        super(itemView);

        this.presenter = presenter;
        thesisName = itemView.findViewById(R.id.thesis_name);
        thesisDescription = itemView.findViewById(R.id.thesis_description);
        itemView.setOnClickListener(this);
    }

    @Override
    public void bind(@NonNull Thesis entity) {
        thesis = entity;
        thesisName.setText(entity.getThesisName());

        String thesisDescriptionText = entity.getThesisDescription();

        thesisDescriptionText =
                thesisDescriptionText.length() > DEST_STR_LENGTH
                ? thesisDescriptionText.substring(0,
                                              DEST_STR_LENGTH)
                : thesisDescriptionText;

        thesisDescription.setText(thesisDescriptionText);
    }

    @Override
    public void onClick(View view) {
        presenter.openThesis(Objects.requireNonNull(thesis));
    }
}
