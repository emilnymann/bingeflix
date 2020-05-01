package com.datamatiker.bingeflix.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;

@Entity
public class DbTvShow {

    @PrimaryKey(autoGenerate = false)
    public int id;

    public String name;
    public String overview;
    public Date firstAirDate;
    public Date lastAirDate;
    public int numberOfSeasons;
    public int numberOfEpisodes;
    public int episodeRuntime;
    public String status;
    public String homepage;
    public String originalLanguage;
    public ArrayList<String> genres;
    public ArrayList<String> networks;
    public String posterPath;
    public double voteAverage;

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
    }
}
