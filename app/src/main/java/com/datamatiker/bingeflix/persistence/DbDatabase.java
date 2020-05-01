package com.datamatiker.bingeflix.persistence;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = { DbTvShow.class, DbApiConfig.class }, version = 6, exportSchema = false)
public abstract class DbDatabase extends RoomDatabase {
    public abstract DbTvShowDAO dbTvShowDAO();
    public abstract DbApiConfigDAO dbApiConfigDAO();

    private static DbDatabase dbDatabaseInstance;

    public static synchronized DbDatabase getInstance(Context context) {
        if (dbDatabaseInstance == null) {
            dbDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(), DbDatabase.class, "BingeflixDatabase").fallbackToDestructiveMigration().build();
        }

        return dbDatabaseInstance;
    }
}
