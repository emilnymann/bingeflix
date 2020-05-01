package com.datamatiker.bingeflix.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DbTvShowDAO {

    @Insert
    void insertTvShow(DbTvShow... DbTvShows);

    @Query("SELECT * from DbTvShow")
    LiveData<List<DbTvShow>> getAllTvShows();

    @Query("SELECT * from DbTvShow WHERE id = :id")
    LiveData<DbTvShow> getTvShowById(int id);

    @Query("SELECT COUNT(*) from DbTvShow")
    LiveData<Integer> countTvShows();

    @Delete
    void deleteTvShow(DbTvShow dbTvShow);

}
