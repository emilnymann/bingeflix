package com.datamatiker.bingeflix.persistence;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.datamatiker.bingeflix.model.LocalDateTimeConverter;
import com.datamatiker.bingeflix.model.PosterSizeConverter;
import com.datamatiker.bingeflix.model.PosterSizes;

import java.time.LocalDateTime;

@Entity
public class DbApiConfig {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String baseUrl;
    public String secureBaseUrl;
    @TypeConverters(PosterSizeConverter.class)
    public PosterSizes posterSizes;
    @TypeConverters(LocalDateTimeConverter.class)
    public LocalDateTime cacheDate;

    public DbApiConfig(String baseUrl, String secureBaseUrl) {
        this.baseUrl = baseUrl;
        this.secureBaseUrl = secureBaseUrl;
        this.cacheDate = LocalDateTime.now();
    }
}
