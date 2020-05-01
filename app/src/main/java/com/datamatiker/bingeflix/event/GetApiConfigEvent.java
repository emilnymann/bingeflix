package com.datamatiker.bingeflix.event;

import com.datamatiker.bingeflix.persistence.DbApiConfig;

public class GetApiConfigEvent {

    public DbApiConfig dbApiConfig;

    public GetApiConfigEvent(DbApiConfig dbApiConfig) {
        this.dbApiConfig = dbApiConfig;
    }
}
