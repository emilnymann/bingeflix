package com.datamatiker.bingeflix.ui.discover;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.datamatiker.bingeflix.persistence.DbTvShow;
import com.datamatiker.bingeflix.persistence.TvShowRepository;

public class DiscoverViewModel extends AndroidViewModel {

    private TvShowRepository tvShowRepository;
    private LiveData<DbTvShow> tvShowTest;

    public DiscoverViewModel(@NonNull Application application) {
        super(application);
        tvShowRepository = new TvShowRepository(application.getApplicationContext());
        tvShowTest = tvShowRepository.getTvShowById(1396);
    }

    public LiveData<DbTvShow> getTvShow() {
       return tvShowTest;
    }
}