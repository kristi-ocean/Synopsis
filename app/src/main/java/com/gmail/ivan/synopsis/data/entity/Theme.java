package com.gmail.ivan.synopsis.data.entity;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Theme {

    @NonNull
    @PrimaryKey
    private String themeName;

    @Ignore
    private int thesisCount;

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

    public int getThesisCount() {
        return thesisCount;
    }

    public void setThesisCount(int thesisCount) {
        this.thesisCount = thesisCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(o.getClass())) {
            return false;
        }
        Theme theme = (Theme) o;
        return themeName.equals(theme.themeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(themeName);
    }
}
