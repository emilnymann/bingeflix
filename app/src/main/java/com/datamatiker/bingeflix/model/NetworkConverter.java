package com.datamatiker.bingeflix.model;

import android.net.Network;
import androidx.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;

public class NetworkConverter {

    @TypeConverter
    public Networks storedStringToGenres(String value) {
        ArrayList<String> networks = new ArrayList<>();
        networks.addAll(Arrays.asList(value.split("\\s*,\\s*")));
        return new Networks(networks);
    }

    @TypeConverter
    public String genresToStoredString(Networks networks) {
        String value = "";

        for (String network : networks.getNetworks()) {
            value += network + ",";
        }

        return value;
    }

}
