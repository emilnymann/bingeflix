package com.datamatiker.bingeflix;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import com.datamatiker.bingeflix.ui.profilesetup.ProfileSetupPersonalFragment;
import com.datamatiker.bingeflix.ui.profilesetup.ProfileSetupStartFragment;

public class ProfileSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_setup_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ProfileSetupStartFragment.newInstance())
                    .commitNow();
        }
    }

    public void profileSetupStartContinue(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ProfileSetupPersonalFragment newFragment = ProfileSetupPersonalFragment.newInstance();

        // This sets the enter/exit animations when changing fragment. TODO: figure out how to make custom animation resources
        //ft.setCustomAnimations(R.anim.fragment_open_enter, R.anim.fragment_close_exit);
        ft.replace(R.id.container, ProfileSetupPersonalFragment.newInstance())
        .commitNow();
    }
}
