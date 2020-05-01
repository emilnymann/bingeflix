package com.datamatiker.bingeflix.persistence;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = DbTvShow.class, version = 2)
public abstract class DbDatabase extends RoomDatabase {
    public abstract DbTvShowDAO dbTvShowDAO();

    private static DbDatabase dbDatabaseInstance;

    public static synchronized DbDatabase getInstance(Context context) {
        if (dbDatabaseInstance == null) {
            dbDatabaseInstance = Room.databaseBuilder(context.getApplicationContext(), DbDatabase.class, "BingeflixDatabase").build();
        }

        return dbDatabaseInstance;
    }
}
