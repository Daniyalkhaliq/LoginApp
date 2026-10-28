package com.example.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        TextView tvGreeting = findViewById(R.id.tvGreeting);
        tvGreeting.setText(getString(R.string.greeting, UserStore.name));

        findViewById(R.id.cardProfile).setOnClickListener(v ->
                startActivity(new Intent(this, ProfileActivity.class)));

        View.OnClickListener soon = v ->
                Toast.makeText(this, R.string.coming_soon, Toast.LENGTH_SHORT).show();
        findViewById(R.id.cardTasks).setOnClickListener(soon);
        findViewById(R.id.cardMessages).setOnClickListener(soon);
        findViewById(R.id.cardSettings).setOnClickListener(soon);
    }
}