package com.gmail.ivan.synopsis.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Theme {

    @NonNull
    @PrimaryKey
    private String themeName;

    public Theme() {
        this("");
    }

    public Theme(@NonNull String themeName) {
        this.themeName = themeName;
    }

    @NonNull
    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(@NonNull String themeName) {
        this.themeName = themeName;
    }
}
