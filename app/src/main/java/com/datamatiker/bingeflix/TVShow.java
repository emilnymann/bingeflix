package com.datamatiker.bingeflix;

import java.util.ArrayList;
import java.util.Date;

public class TVShow {

    private int id;
    private String title;
    private String synopsis;
    private Date firstAired;
    private Date lastAired;
    private int numSeasons;
    private int numEpisodes;
    private int runtime;
    private boolean ongoing;
    private Language language;
    private String parentalGuide;
    private ArrayList<Genre> genres;
    private ArrayList<Network> networks;
    private String poster;
    private String imdbUrl;
    private String tvdbUrl;
    private String rating;
    private ArrayList<Actor> featuredActors;

    public TVShow(int id, String title, String synopsis, Date firstAired, Date lastAired, int numSeasons, int numEpisodes, int runtime, boolean ongoing, Language language, String parentalGuide, ArrayList<Genre> genres, ArrayList<Network> networks, String poster, String imdbUrl, String tvdbUrl, String rating, ArrayList<Actor> featuredActors) {
        this.id = id;
        this.title = title;
        this.synopsis = synopsis;
        this.firstAired = firstAired;
        this.lastAired = lastAired;
        this.numSeasons = numSeasons;
        this.numEpisodes = numEpisodes;
        this.runtime = runtime;
        this.ongoing = ongoing;
        this.language = language;
        this.parentalGuide = parentalGuide;
        this.genres = genres;
        this.networks = networks;
        this.poster = poster;
        this.imdbUrl = imdbUrl;
        this.tvdbUrl = tvdbUrl;
        this.rating = rating;
        this.featuredActors = featuredActors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Date getFirstAired() {
        return firstAired;
    }

    public void setFirstAired(Date firstAired) {
        this.firstAired = firstAired;
    }

    public Date getLastAired() {
        return lastAired;
    }

    public void setLastAired(Date lastAired) {
        this.lastAired = lastAired;
    }

    public int getNumSeasons() {
        return numSeasons;
    }

    public void setNumSeasons(int numSeasons) {
        this.numSeasons = numSeasons;
    }

    public int getNumEpisodes() {
        return numEpisodes;
    }

    public void setNumEpisodes(int numEpisodes) {
        this.numEpisodes = numEpisodes;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public boolean isOngoing() {
        return ongoing;
    }

    public void setOngoing(boolean ongoing) {
        this.ongoing = ongoing;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getParentalGuide() {
        return parentalGuide;
    }

    public void setParentalGuide(String parentalGuide) {
        this.parentalGuide = parentalGuide;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public ArrayList<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(ArrayList<Network> networks) {
        this.networks = networks;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbUrl() {
        return imdbUrl;
    }

    public void setImdbUrl(String imdbUrl) {
        this.imdbUrl = imdbUrl;
    }

    public String getTvdbUrl() {
        return tvdbUrl;
    }

    public void setTvdbUrl(String tvdbUrl) {
        this.tvdbUrl = tvdbUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ArrayList<Actor> getFeaturedActors() {
        return featuredActors;
    }

    public void setFeaturedActors(ArrayList<Actor> featuredActors) {
        this.featuredActors = featuredActors;
    }
}
