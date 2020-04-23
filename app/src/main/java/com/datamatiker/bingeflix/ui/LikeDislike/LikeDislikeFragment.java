package com.datamatiker.bingeflix.ui.LikeDislike;

import android.os.Bundle;
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

public class LikeDislikeFragment extends Fragment {

    private LikeDislikeViewModel likeDislikeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        likeDislikeViewModel =
                ViewModelProviders.of(this).get(LikeDislikeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_likedislike, container, false);
        final TextView textView = root.findViewById(R.id.text_likeDislike);
        likeDislikeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}