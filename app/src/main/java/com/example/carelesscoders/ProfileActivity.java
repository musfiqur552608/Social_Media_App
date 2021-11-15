package com.example.carelesscoders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    private TextView profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("My Profile");
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        profile = findViewById(R.id.profileTv);
    }

    private void checkUserStatus(){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user != null){
            profile.setText(user.getEmail());
        }
        else {
            startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            finish();
        }
    }

    @Override
    protected void onStart() {
        checkUserStatus();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.logoutId){
            firebaseAuth.signOut();
            checkUserStatus();
        }

        return super.onOptionsItemSelected(item);
    }
}