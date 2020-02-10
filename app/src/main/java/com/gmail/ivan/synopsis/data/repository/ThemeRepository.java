package com.gmail.ivan.synopsis.data.repository;

import com.gmail.ivan.synopsis.data.entity.Theme;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ThemeRepository {

    @Insert
    void addTheme(@NonNull Theme theme);

    @NonNull
    @Query("SELECT * FROM theme")
    List<Theme> getAllThemes();

    @Delete
    void deleteTheme(@NonNull Theme theme);
}
