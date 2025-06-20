package com.example.elections_app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.elections_app.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialisation du view binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Configuration de la barre d'outils
        setSupportActionBar(binding.topAppBar);

        // Configuration de la navigation
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        // Définir les destinations de niveau supérieur
        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.circonscriptionFragment,
                R.id.centreVoteFragment,
                R.id.bureauVoteFragment,
                R.id.gestionObjetsFragment,
                R.id.saisieResultatFragment,
                R.id.validationResultatsFragment)
                .setOpenableLayout(binding.drawerLayout)
                .build();

        // Configurer l'ActionBar avec NavController
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        // Configurer la NavigationView avec NavController
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}