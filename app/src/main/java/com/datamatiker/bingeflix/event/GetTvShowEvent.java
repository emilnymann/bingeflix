package com.datamatiker.bingeflix.event;

import com.datamatiker.bingeflix.persistence.DbTvShow;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class GetTvShowEvent {

    public DbTvShow tvShow;

    public GetTvShowEvent(DbTvShow tvShow) {
        this.tvShow = tvShow;
    }
}
