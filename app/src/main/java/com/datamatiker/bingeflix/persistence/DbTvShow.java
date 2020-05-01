package com.datamatiker.bingeflix.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.datamatiker.bingeflix.model.Genres;
import com.datamatiker.bingeflix.model.Networks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class DbTvShow {

    @PrimaryKey(autoGenerate = false)
    public int id;

    public String name;
    public String overview;
    public String firstAirDate;
    public String lastAirDate;
    public int numberOfSeasons;
    public int numberOfEpisodes;
    public int episodeRuntime;
    public String status;
    public String homepage;
    public String originalLanguage;
    public Genres genres;
    public Networks networks;
    public String posterPath;
    public double voteAverage;
    public String cacheDate;

    public DbTvShow(int id, String name, String overview, int numberOfSeasons, int numberOfEpisodes, int episodeRuntime, String status, String originalLanguage, String posterPath, double voteAverage) {
        this.id = id;
        this.name = name;
        this.overview = overview;
        this.numberOfSeasons = numberOfSeasons;
        this.numberOfEpisodes = numberOfEpisodes;
        this.episodeRuntime = episodeRuntime;
        this.status = status;
        this.originalLanguage = originalLanguage;
        this.posterPath = posterPath;
        this.voteAverage = voteAverage;
        this.cacheDate = LocalDateTime.now();
    }
}
