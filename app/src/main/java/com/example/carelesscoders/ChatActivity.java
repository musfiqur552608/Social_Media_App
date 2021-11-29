package com.example.carelesscoders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private ImageView profileId;
    private TextView nameId, userStatus;
    private ImageButton sendBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");
        recyclerView = findViewById(R.id.chatRecyclerId);
        profileId = findViewById(R.id.profileId);
        nameId = findViewById(R.id.nameId);
        userStatus = findViewById(R.id.userStatusId);
        sendBtn = findViewById(R.id.sendBtn);
    }
}