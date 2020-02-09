package com.gmail.ivan.synopsis.data.repository;

import com.gmail.ivan.synopsis.data.entity.Theme;

import java.util.List;

import androidx.annotation.NonNull;

public interface ThemeRepository {

    void addTheme(@NonNull Theme theme);

    @NonNull
    List<Theme> getAllThemes();

    void deleteTheme(@NonNull Theme theme);
}
