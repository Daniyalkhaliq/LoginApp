package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        TextInputLayout tilEmail = findViewById(R.id.tilEmail);
        TextInputEditText etEmail = findViewById(R.id.etEmail);
        Button btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(v -> {
            tilEmail.setError(null);
            String email = etEmail.getText() == null ? "" : etEmail.getText().toString().trim();

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tilEmail.setError(getString(R.string.error_invalid_email));
                return;
            }
            if (!email.equalsIgnoreCase(UserStore.email)) {
                tilEmail.setError(getString(R.string.no_account));
                return;
            }

            Toast.makeText(this, R.string.recovery_sent, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ResetPasswordActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();
        });
    }
}