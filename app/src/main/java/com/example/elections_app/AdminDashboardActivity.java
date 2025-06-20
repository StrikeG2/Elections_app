package com.example.elections_app;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AdminDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        // Configuration de l'interface administrateur
        TextView adminTitle = findViewById(R.id.adminTitle);
        adminTitle.setText("Interface Administrateur");
    }
}