package com.example.elections_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);

        // Récupérer les données de l'intent
        String userEmail = getIntent().getStringExtra("user_email");

        // Afficher les informations utilisateur
        TextView welcomeText = findViewById(R.id.welcomeText);
        welcomeText.setText("Bienvenue dans votre espace électoral\n" + userEmail);
    }
}