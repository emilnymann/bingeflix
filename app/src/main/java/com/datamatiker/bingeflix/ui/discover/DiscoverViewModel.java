package com.datamatiker.bingeflix.ui.discover;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.datamatiker.bingeflix.event.GetTvShowEvent;
import com.datamatiker.bingeflix.persistence.DbTvShow;
import com.datamatiker.bingeflix.persistence.TvShowRepository;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static android.content.ContentValues.TAG;

public class DiscoverViewModel extends AndroidViewModel {

    private TvShowRepository tvShowRepository;
    private DbTvShow tvShowTest;

    public DiscoverViewModel(@NonNull Application application) {
        super(application);
        EventBus.getDefault().register(this);
        tvShowRepository = new TvShowRepository(application.getApplicationContext());
        tvShowRepository.getTvShowById(1396);
    }

    public DbTvShow getTvShow() {
       return tvShowTest;
    }

    @Subscribe
    public void onGetTvShowEvent(GetTvShowEvent getTvShowEvent) {
        tvShowTest = getTvShowEvent.tvShow;
        Log.d(TAG, "onGetTvShowEvent: " + getTvShow().name);
    }
}