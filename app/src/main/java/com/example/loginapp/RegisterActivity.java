package com.example.loginapp;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout tilName, tilEmail, tilPassword, tilConfirm;
    TextInputEditText etName, etEmail, etPassword, etConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tilName = findViewById(R.id.tilName);
        tilEmail = findViewById(R.id.tilEmail);
        tilPassword = findViewById(R.id.tilPassword);
        tilConfirm = findViewById(R.id.tilConfirm);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvLogin = findViewById(R.id.tvLogin);

        btnRegister.setOnClickListener(v -> attemptRegister());
        tvLogin.setOnClickListener(v -> finish());
    }

    private String text(TextInputEditText e) {
        return e.getText() == null ? "" : e.getText().toString().trim();
    }

    private void attemptRegister() {
        tilName.setError(null);
        tilEmail.setError(null);
        tilPassword.setError(null);
        tilConfirm.setError(null);

        String name = text(etName);
        String email = text(etEmail);
        String pass = text(etPassword);
        String confirm = text(etConfirm);

        boolean ok = true;
        if (name.isEmpty()) {
            tilName.setError(getString(R.string.error_required));
            ok = false;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError(getString(R.string.error_invalid_email));
            ok = false;
        }
        if (pass.length() < 6) {
            tilPassword.setError(getString(R.string.error_password_short));
            ok = false;
        }
        if (!pass.equals(confirm)) {
            tilConfirm.setError(getString(R.string.error_password_mismatch));
            ok = false;
        }
        if (!ok) return;

        UserStore.name = name;
        UserStore.email = email;
        UserStore.username = email;
        UserStore.password = pass;

        Toast.makeText(this, R.string.account_created, Toast.LENGTH_SHORT).show();
        finish();
    }
}