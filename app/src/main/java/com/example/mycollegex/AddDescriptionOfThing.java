package com.example.mycollegex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import DbHandles.PostDaos;

public class AddDescriptionOfThing extends AppCompatActivity {

    Button PostButton;
    EditText PostInput;
    String toPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_description_of_thing);

        initViews();

        PostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toPost = PostInput.getText().toString().trim();
                if (toPost!=null){
                    PostDaos postDaos = new PostDaos();
                    postDaos.addPost(toPost);

                }
            }
        });
    }

    public void initViews(){
        PostButton = findViewById(R.id.post_description);
        PostInput = findViewById(R.id.description_edit_text);
    }
}