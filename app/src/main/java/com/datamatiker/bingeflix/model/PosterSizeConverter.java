package com.datamatiker.bingeflix.model;

import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;

public class PosterSizeConverter {

    @TypeConverter
    public PosterSizes storedStringToPosterSizes(String value) {
        ArrayList<String> posterSizes = new ArrayList<>();
        posterSizes.addAll(Arrays.asList(value.split("\\s*,\\s*")));
        return new PosterSizes(posterSizes);
    }

    @TypeConverter
    public String posterSizesToStoredString(PosterSizes posterSizes) {
        String value = "";

        for (String posterSize : posterSizes.getPosterSizes()) {
            value += posterSize + ",";
        }

        return value;
    }

}
