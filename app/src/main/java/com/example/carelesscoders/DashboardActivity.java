package com.example.carelesscoders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        actionBar = getSupportActionBar();
        actionBar.setTitle("My Profile");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        BottomNavigationView navigationView = findViewById(R.id.navigation);

        navigationView.setOnNavigationItemSelectedListener(selectedListener);

        actionBar.setTitle("Home");
        HomeFragment fragment1 = new HomeFragment();
        FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
        transaction1.replace(R.id.content, fragment1,"");
        transaction1.commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            actionBar.setTitle("Home");
                            HomeFragment fragment1 = new HomeFragment();
                            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                            transaction1.replace(R.id.content, fragment1,"");
                            transaction1.commit();
                            return true;
                        case R.id.nav_profile:
                            actionBar.setTitle("Profile");
                            ProfileFragment fragment2 = new ProfileFragment();
                            FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                            transaction2.replace(R.id.content, fragment2,"");
                            transaction2.commit();
                            return true;
                        case R.id.nav_users:
                            actionBar.setTitle("Careless Coder");
                            UsersFragment fragment3 = new UsersFragment();
                            FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                            transaction3.replace(R.id.content, fragment3,"");
                            transaction3.commit();
                            return true;
                        case R.id.nav_chat:
                            actionBar.setTitle("Chats");
                            ChatListFragment fragment4 = new ChatListFragment();
                            FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                            transaction4.replace(R.id.content, fragment4,"");
                            transaction4.commit();
                            return true;
                    }

                    return false;
                }
            };

    private void checkUserStatus() {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {

        } else {
            startActivity(new Intent(DashboardActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart() {
        checkUserStatus();
        super.onStart();
    }


}