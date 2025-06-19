package com.example.elections_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BureauVoteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BureauVoteFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bureau_vote, container, false);

        // Logique pour le bureau de vote

        return view;
    }
}