package com.datamatiker.bingeflix.model;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;

public class GenreConverter {

    @TypeConverter
    public Genres storedStringToGenres(String value) {
        ArrayList<String> genres = new ArrayList<>();
        genres.addAll(Arrays.asList(value.split("\\s*,\\s*")));
        return new Genres(genres);
    }

    @TypeConverter
    public String genresToStoredString(Genres genres) {
        String value = "";

        for (String genre : genres.getGenres()) {
            value += genre + ",";
        }

        return value;
    }

}
