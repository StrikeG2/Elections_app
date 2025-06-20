package com.example.elections_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class HeaderFragment extends Fragment {
    private NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_header, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

        view.findViewById(R.id.tab_circonscription).setOnClickListener(v ->
                navController.navigate(R.id.circonscriptionFragment));

        view.findViewById(R.id.tab_centre_vote).setOnClickListener(v ->
                navController.navigate(R.id.centreVoteFragment));

        view.findViewById(R.id.tab_bureau_vote).setOnClickListener(v ->
                navController.navigate(R.id.bureauVoteFragment));
    }
}