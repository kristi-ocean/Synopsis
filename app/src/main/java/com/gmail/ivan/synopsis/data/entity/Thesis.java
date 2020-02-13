package com.gmail.ivan.synopsis.data.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Thesis {

    @PrimaryKey
    @NonNull
    private final String id;

    @NonNull
    private String themeName;

    @NonNull
    private String thesisName;

    @NonNull
    private String thesisDescription;

    @Ignore
    public Thesis(@NonNull String id, @NonNull String themeName) {
        this.id = id;
        this.themeName = themeName;
        thesisName = "New thesis";
        thesisDescription = "";
    }

    public Thesis(@NonNull String id,
                  @NonNull String themeName,
                  @NonNull String thesisName,
                  @NonNull String thesisDescription) {
        this.id = id;
        this.themeName = themeName;
        this.thesisName = thesisName;
        this.thesisDescription = thesisDescription;
    }

    @NonNull
    public String getId() {
        return id;
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
