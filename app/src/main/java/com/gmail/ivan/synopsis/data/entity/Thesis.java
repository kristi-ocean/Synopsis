package com.gmail.ivan.synopsis.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Thesis {

    @NonNull
    private String themeName;

    @NonNull
    @PrimaryKey
    private String thesisName;

    @NonNull
    private String thesisDescription;

    public Thesis(@NonNull String themeName,
                  @NonNull String thesisName,
                  @NonNull String thesisDescription) {
        this.themeName = themeName;
        this.thesisName = thesisName;
        this.thesisDescription = thesisDescription;
    }

    @NonNull
    public String getThesisName() {
        return thesisName;
    }

    public void setThesisName(@NonNull String thesisName) {
        this.thesisName = thesisName;
    }

    @NonNull
    public String getThesisDescription() {
        return thesisDescription;
    }

    public void setThesisDescription(@NonNull String thesisDescription) {
        this.thesisDescription = thesisDescription;
    }

    @NonNull
    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(@NonNull String themeName) {
        this.themeName = themeName;
    }
}
