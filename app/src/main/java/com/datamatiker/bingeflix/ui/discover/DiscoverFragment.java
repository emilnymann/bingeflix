package com.datamatiker.bingeflix.ui.discover;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.datamatiker.bingeflix.R;

import static android.content.ContentValues.TAG;

public class DiscoverFragment extends Fragment {

    private DiscoverViewModel DiscoverViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DiscoverViewModel = ViewModelProviders.of(this).get(DiscoverViewModel.class);
        View root = inflater.inflate(R.layout.fragment_discover, container, false);
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onCreateView: " + DiscoverViewModel.getTvShow());
    }
}