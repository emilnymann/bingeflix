package com.datamatiker.bingeflix.ui.profilesetup;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.datamatiker.bingeflix.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileSetupGenresFragment extends Fragment {

    private ProfileSetupViewModel mViewModel;

    public static ProfileSetupGenresFragment newInstance() {
        return new ProfileSetupGenresFragment();
    }

    public ProfileSetupGenresFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_setup_personal_fragment, container, false);
    }

}
