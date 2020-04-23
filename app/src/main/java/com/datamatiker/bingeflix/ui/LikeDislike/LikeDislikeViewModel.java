package com.datamatiker.bingeflix.ui.LikeDislike;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LikeDislikeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LikeDislikeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is like or dislike fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}