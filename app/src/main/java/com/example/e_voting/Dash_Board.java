package com.example.e_voting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Dash_Board extends AppCompatActivity {
    NavigationView navigation;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionbartoggle;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash__board);


        setUptoolBar(); //function for setting the toolbar and navigation drawer
        navigation = findViewById(R.id.navigaionView);
        /****
         * *Logic for menu items when they are clicked.
         * every intent carries a string and those string are received in the main activity.
         *****/
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_aboutus:
                        Toast.makeText(Dash_Board.this, "About us", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_share:
                        Toast.makeText(Dash_Board.this, "Share", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_campaign:
                        Toast.makeText(Dash_Board.this, "Campaign", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_politics:
                        Toast.makeText(Dash_Board.this, "Politics", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    private void setUptoolBar() {
        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);

        actionbartoggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionbartoggle);
        actionbartoggle.syncState();
    }

}