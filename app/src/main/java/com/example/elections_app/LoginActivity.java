// LoginActivity.java
package com.example.elections_app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class LoginActivity extends AppCompatActivity {

    // Vues
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewAdminInfo;

    // Constantes
    private static final String ADMIN_EMAIL = "admin@test.com";
    private static final String ADMIN_PASSWORD = "admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialiser les vues
        initViews();

        // Configurer les événements
        setupEventListeners();

        // Configuration de l'interface
        setupUI();
    }

    private void initViews() {
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewAdminInfo = findViewById(R.id.textViewAdminInfo);
    }

    private void setupEventListeners() {
        // Événement de clic sur le bouton de connexion
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptLogin();
            }
        });

        // Événement de clic sur le texte admin
        textViewAdminInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillAdminCredentials();
            }
        });
    }

    private void setupUI() {
        // Configuration du texte admin avec couleur
        textViewAdminInfo.setTextColor(ContextCompat.getColor(this, R.color.primary_blue));

        // Placeholder pour les champs
        editTextEmail.setHint("votre.email@example.com");
        editTextPassword.setHint("••••••••");
    }

    private void attemptLogin() {
        // Récupérer les valeurs des champs
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // Réinitialiser les erreurs
        editTextEmail.setError(null);
        editTextPassword.setError(null);

        boolean cancel = false;
        View focusView = null;

        // Vérifier le mot de passe
        if (TextUtils.isEmpty(password)) {
            editTextPassword.setError("Ce champ est requis");
            focusView = editTextPassword;
            cancel = true;
        } else if (password.length() < 4) {
            editTextPassword.setError("Le mot de passe est trop court");
            focusView = editTextPassword;
            cancel = true;
        }

        // Vérifier l'email
        if (TextUtils.isEmpty(email)) {
            editTextEmail.setError("Ce champ est requis");
            focusView = editTextEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            editTextEmail.setError("Cette adresse email n'est pas valide");
            focusView = editTextEmail;
            cancel = true;
        }

        if (cancel) {
            // Il y a une erreur, focus sur le premier champ invalide
            focusView.requestFocus();
        } else {
            // Effectuer la connexion
            performLogin(email, password);
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@") && email.contains(".");
    }

    private void performLogin(String email, String password) {
        // Désactiver le bouton pendant la connexion
        buttonLogin.setEnabled(false);
        buttonLogin.setText("Connexion...");

        // Simuler un délai de connexion
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Vérifier les identifiants
                if (isValidCredentials(email, password)) {
                    // Connexion réussie
                    loginSuccess(email);
                } else {
                    // Échec de connexion
                    loginFailed();
                }

                // Réactiver le bouton
                buttonLogin.setEnabled(true);
                buttonLogin.setText("Se connecter");
            }
        }, 2000); // 2 secondes de délai
    }

    private boolean isValidCredentials(String email, String password) {
        // Vérification simple - à remplacer par une vraie authentification
        return (email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD)) ||
                (email.equals("user@test.com") && password.equals("user123"));
    }

    private void loginSuccess(String email) {
        Toast.makeText(this, "Connexion réussie!", Toast.LENGTH_SHORT).show();

        // Déterminer le type d'utilisateur
        boolean isAdmin = email.equals(ADMIN_EMAIL);

        // Naviguer vers l'interface appropriée
        Intent intent;
        if (isAdmin) {
            intent = new Intent(this, AdminDashboardActivity.class);
        } else {
            intent = new Intent(this, UserDashboardActivity.class);
        }

        intent.putExtra("user_email", email);
        intent.putExtra("is_admin", isAdmin);
        startActivity(intent);
        finish();
    }

    private void loginFailed() {
        Toast.makeText(this, "Email ou mot de passe incorrect", Toast.LENGTH_LONG).show();

        // Effacer le mot de passe
        editTextPassword.setText("");
        editTextPassword.requestFocus();

        // Animation de secousse pour les champs
        shakeView(editTextEmail);
        shakeView(editTextPassword);
    }

    private void fillAdminCredentials() {
        editTextEmail.setText(ADMIN_EMAIL);
        editTextPassword.setText(ADMIN_PASSWORD);
        Toast.makeText(this, "Identifiants admin remplis", Toast.LENGTH_SHORT).show();
    }

    private void shakeView(View view) {
        view.animate()
                .translationX(-10f)
                .setDuration(50)
                .withEndAction(() -> {
                    view.animate()
                            .translationX(10f)
                            .setDuration(50)
                            .withEndAction(() -> {
                                view.animate()
                                        .translationX(0f)
                                        .setDuration(50);
                            });
                });
    }

    @Override
    public void onBackPressed() {
        // Permettre de revenir à l'écran précédent
        super.onBackPressed();
    }
}
