package com.gmail.ivan.synopsis.data.repository;

import com.gmail.ivan.synopsis.data.entity.Thesis;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ThesisRepository {

    @Insert
    void addThesis(@NonNull Thesis thesis);

    @Query("SELECT * FROM thesis Where id = :thesisId")
    Thesis getThesis(int thesisId);

    @Update
    void updateThesis(@NonNull Thesis thesis);

    @Delete
    void deleteThesis(@NonNull Thesis thesis);

    @NonNull
    @Query("SELECT * FROM thesis WHERE themeName = :themeName")
    List<Thesis> getThesisList(@NonNull String themeName);
}
