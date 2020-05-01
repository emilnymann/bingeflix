package com.datamatiker.bingeflix.ui.discover;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.datamatiker.bingeflix.event.GetApiConfigEvent;
import com.datamatiker.bingeflix.event.GetTvShowEvent;
import com.datamatiker.bingeflix.persistence.ApiConfigRepository;
import com.datamatiker.bingeflix.persistence.DbApiConfig;
import com.datamatiker.bingeflix.persistence.DbTvShow;
import com.datamatiker.bingeflix.persistence.TvShowRepository;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static android.content.ContentValues.TAG;

public class DiscoverViewModel extends AndroidViewModel {

    private TvShowRepository tvShowRepository;
    private ApiConfigRepository apiConfigRepository;
    private DbTvShow tvShowTest;
    private DbApiConfig apiConfigTest;

    public DiscoverViewModel(@NonNull Application application) {
        super(application);
        EventBus.getDefault().register(this);
        tvShowRepository = new TvShowRepository(application.getApplicationContext());
        apiConfigRepository = new ApiConfigRepository(application.getApplicationContext());
        tvShowRepository.getTvShowById(1396);
        apiConfigRepository.getApiConfig();

    }

    public DbTvShow getTvShow() {
       return tvShowTest;
    }

    public DbApiConfig getApiConfigTest() {
        return apiConfigTest;
    }

    @Subscribe
    public void onGetTvShowEvent(GetTvShowEvent getTvShowEvent) {
        tvShowTest = getTvShowEvent.tvShow;
        Log.d(TAG, "onGetTvShowEvent: " + getTvShow().name);
    }

    @Subscribe
    public void onGetApiConfigEvent(GetApiConfigEvent getApiConfigEvent) {
        apiConfigTest = getApiConfigEvent.dbApiConfig;
        Log.d(TAG, "onGetApiConfigEvent: " + getApiConfigTest().secureBaseUrl);
    }
}