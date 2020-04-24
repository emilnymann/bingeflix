package com.datamatiker.bingeflix.ui.profilesetup;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.datamatiker.bingeflix.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileSetupPersonalFragment extends Fragment {

    private ProfileSetupViewModel mViewModel;

    public static ProfileSetupPersonalFragment newInstance() {
        return new ProfileSetupPersonalFragment();
    }

    public ProfileSetupPersonalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_setup_personal_fragment, container, false);
    }

}
