package com.example.elections_app.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.elections_app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FooterFragment extends Fragment {
    private NavController navController;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_footer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    navController.navigate(R.id.navigation_home);
                    return true;
                case R.id.navigation_results:
                    navController.navigate(R.id.navigation_results);
                    return true;
                case R.id.navigation_settings:
                    navController.navigate(R.id.navigation_settings);
                    return true;
                default:
                    return false;
            }
        });
    }
}
