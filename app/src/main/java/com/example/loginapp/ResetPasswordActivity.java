package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        TextView tvEmail = findViewById(R.id.tvEmail);
        TextInputLayout tilNew = findViewById(R.id.tilNew);
        TextInputLayout tilConfirm = findViewById(R.id.tilConfirm);
        TextInputEditText etNew = findViewById(R.id.etNew);
        TextInputEditText etConfirm = findViewById(R.id.etConfirm);
        Button btnReset = findViewById(R.id.btnReset);

        tvEmail.setText(getIntent().getStringExtra("email"));

        btnReset.setOnClickListener(v -> {
            tilNew.setError(null);
            tilConfirm.setError(null);
            String pass = etNew.getText() == null ? "" : etNew.getText().toString();
            String confirm = etConfirm.getText() == null ? "" : etConfirm.getText().toString();

            boolean ok = true;
            if (pass.length() < 6) {
                tilNew.setError(getString(R.string.error_password_short));
                ok = false;
            }
            if (!pass.equals(confirm)) {
                tilConfirm.setError(getString(R.string.error_password_mismatch));
                ok = false;
            }
            if (!ok) return;

            UserStore.password = pass;
            Toast.makeText(this, R.string.reset_success, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}