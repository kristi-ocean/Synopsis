package com.gmail.ivan.synopsis.data.repository;

import com.gmail.ivan.synopsis.data.entity.Theme;
import com.gmail.ivan.synopsis.data.entity.Thesis;

import java.util.List;

import androidx.annotation.NonNull;

public interface ThesisRepository {

    void addThesis(@NonNull Thesis thesis);

    void updateThesis(@NonNull Thesis thesis);

    void deleteThesis(@NonNull Thesis thesis);

    @NonNull
    List<Thesis> getThesisList(@NonNull Theme theme);
}
