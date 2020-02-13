package com.gmail.ivan.synopsis.data.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;

public class AppDataBaseSingleton {

    @Nullable
    private static AppDataBaseSingleton appDBSingletone;

    @NonNull
    private final AppDataBase dataBase;

    private AppDataBaseSingleton(Context context) {
        dataBase = Room.databaseBuilder(context, AppDataBase.class, "app_data").build();
    }

    public static AppDataBaseSingleton get(Context context){
        if(appDBSingletone == null){
            appDBSingletone = new AppDataBaseSingleton(context);
        }
        return appDBSingletone;
    }

    @NonNull
    public AppDataBase getDataBase(){
        return dataBase;
    }
}
