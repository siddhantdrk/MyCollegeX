package com.example.mycollegex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.UserInfo;

import DbHandles.UsersDaos;
import models.UsersItem;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton AddPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        UsersDaos usersDaos = new UsersDaos();
        UsersItem usersItem = new UsersItem();
        usersItem.setCollegeEmail("xxxxemail");
        usersItem.setContactNumber("999.....");
        usersItem.setUid("123");
        usersDaos.addUser(usersItem);

        AddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddDescriptionOfThing.class);
                startActivity(intent);

            }
        });
    }
    public void initViews(){
        AddPost = findViewById(R.id.floatingActionButton);
    }
}