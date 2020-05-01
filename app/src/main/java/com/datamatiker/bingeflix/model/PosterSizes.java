package com.datamatiker.bingeflix.model;

import java.util.ArrayList;

public class PosterSizes {

    private ArrayList<String> posterSizes;

    public PosterSizes(ArrayList<String> posterSizes) {
        this.posterSizes = posterSizes;
    }

    public ArrayList<String> getPosterSizes() {
        return posterSizes;
    }

    public void setPosterSizes(ArrayList<String> posterSizes) {
        this.posterSizes = posterSizes;
    }

}
