package com.gmail.ivan.synopsis.data.database;

import com.gmail.ivan.synopsis.data.entity.Theme;
import com.gmail.ivan.synopsis.data.entity.Thesis;
import com.gmail.ivan.synopsis.data.repository.ThemeRepository;
import com.gmail.ivan.synopsis.data.repository.ThesisRepository;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Theme.class, Thesis.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ThemeRepository themeRepository();

    public abstract ThesisRepository thesisRepository();
}
