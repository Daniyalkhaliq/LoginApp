package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tilUsername, tilPassword;
    TextInputEditText etUsername, etPassword;
    Button btnLogin;
    TextView tvForgot, tvRegister, tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tilUsername = findViewById(R.id.tilUsername);
        tilPassword = findViewById(R.id.tilPassword);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgot = findViewById(R.id.tvForgot);
        tvRegister = findViewById(R.id.tvRegister);
        tvMessage = findViewById(R.id.tvMessage);

        btnLogin.setOnClickListener(v -> attemptLogin());
        tvForgot.setOnClickListener(v ->
                startActivity(new Intent(this, ForgotPasswordActivity.class)));
        tvRegister.setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class)));
    }

    private void attemptLogin() {
        tilUsername.setError(null);
        tilPassword.setError(null);
        tvMessage.setText("");

        String id = etUsername.getText() == null ? "" : etUsername.getText().toString().trim();
        String pass = etPassword.getText() == null ? "" : etPassword.getText().toString();

        boolean ok = true;
        if (id.isEmpty()) {
            tilUsername.setError(getString(R.string.error_required));
            ok = false;
        }
        if (pass.isEmpty()) {
            tilPassword.setError(getString(R.string.error_required));
            ok = false;
        }
        if (!ok) return;

        if (UserStore.login(id, pass)) {
            startActivity(new Intent(this, LandingActivity.class));
            finish();
        } else {
            tvMessage.setText(R.string.invalid_credentials);
        }
    }
}