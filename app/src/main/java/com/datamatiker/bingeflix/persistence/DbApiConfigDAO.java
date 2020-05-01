package com.datamatiker.bingeflix.persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DbApiConfigDAO {

    @Insert
    void insertDbApiConfig(DbApiConfig dbApiConfig);

    @Query("SELECT * from DbApiConfig LIMIT 1")
    DbApiConfig getDbApiConfig();

    @Update
    void updateDbAPiConfig(DbApiConfig dbApiConfig);

}
