package com.example.elections_app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements HeaderFragment.OnTabSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Charger le fragment header
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.header_container, new HeaderFragment())
                    .commit();

            // Charger le fragment de circonscription par défaut
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_container, new CirconscriptionFragment())
                    .commit();
        }
    }

    @Override
    public void onTabSelected(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new CirconscriptionFragment();
                break;
            case 1:
                fragment = new CentreVoteFragment();
                break;
            case 2:
                fragment = new BureauVoteFragment();
                break;
            default:
                fragment = new CirconscriptionFragment();
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_container, fragment)
                .commit();
    }
}