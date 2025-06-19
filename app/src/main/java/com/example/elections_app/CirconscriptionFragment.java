package com.example.elections_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class CirconscriptionFragment extends Fragment {

    private EditText editCodeCirconscription;
    private EditText editNomCirconscription;
    private EditText editNombreBureaux;
    private Button btnCreerCirconscription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.circonscription_page, container, false);

        initViews(view);
        setupClickListeners();

        return view;
    }

    private void initViews(View view) {
        editCodeCirconscription = view.findViewById(R.id.edit_code_circonscription);
        editNomCirconscription = view.findViewById(R.id.edit_nom_circonscription);
        editNombreBureaux = view.findViewById(R.id.edit_nombre_bureaux);
        btnCreerCirconscription = view.findViewById(R.id.btn_creer_circonscription);
    }

    private void setupClickListeners() {
        btnCreerCirconscription.setOnClickListener(v -> {
            String code = editCodeCirconscription.getText().toString().trim();
            String nom = editNomCirconscription.getText().toString().trim();
            String nombreBureaux = editNombreBureaux.getText().toString().trim();

            if (validateInputs(code, nom, nombreBureaux)) {
                // Logique de création de circonscription
                Toast.makeText(getContext(), "Circonscription créée avec succès!", Toast.LENGTH_SHORT).show();
                clearInputs();
            }
        });
    }

    private boolean validateInputs(String code, String nom, String nombreBureaux) {
        if (code.isEmpty()) {
            editCodeCirconscription.setError("Code requis");
            return false;
        }
        if (nom.isEmpty()) {
            editNomCirconscription.setError("Nom requis");
            return false;
        }
        if (nombreBureaux.isEmpty()) {
            editNombreBureaux.setError("Nombre de bureaux requis");
            return false;
        }
        try {
            int nombre = Integer.parseInt(nombreBureaux);
            if (nombre <= 0) {
                editNombreBureaux.setError("Nombre doit être positif");
                return false;
            }
        } catch (NumberFormatException e) {
            editNombreBureaux.setError("Nombre invalide");
            return false;
        }
        return true;
    }

    private void clearInputs() {
        editCodeCirconscription.setText("");
        editNomCirconscription.setText("");
        editNombreBureaux.setText("");
    }
}