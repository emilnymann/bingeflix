package com.datamatiker.bingeflix.model;

import java.util.ArrayList;

public class Genres {

    private ArrayList<String> genres;

    public Genres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }
}
