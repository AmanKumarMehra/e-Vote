package com.example.e_voting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setSelectedItemId(R.id.result);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.campaign:
                        startActivity(new Intent(getApplicationContext(), ElectionCampaign.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.vote:
                        startActivity(new Intent(getApplicationContext(), CandidateList.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.result:

                        return true;
                }

                return false;
            }
        });
    }
}