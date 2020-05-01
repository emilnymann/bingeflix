package com.datamatiker.bingeflix.model;

import androidx.room.TypeConverter;

import java.time.LocalDateTime;

public class LocalDateTimeConverter {

    @TypeConverter
    public LocalDateTime storedStringToDate(String value) {
        if (value == null) {
            return null;
        } else {
            return LocalDateTime.parse(value);
        }
    }

    @TypeConverter
    public String dateToStoredString(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        } else {
            return dateTime.toString();
        }
    }

}
