package com.example.mycollegex.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycollegex.Adapters.PostAdapter;
import com.example.mycollegex.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import com.example.mycollegex.DbHandles.UsersDaos;
import com.example.mycollegex.models.PostsItems;
import com.example.mycollegex.models.UsersItem;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton AddPost;
    PostAdapter adapter;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference postCollection = db.collection("posts");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        UsersDaos usersDaos = new UsersDaos();
        UsersItem usersItem = new UsersItem();
        usersItem.setCollegeEmail("xxxxemail");
        usersItem.setContactNumber("999...888");
        usersItem.setUid("123");
        usersItem.setDisplayName("XYZ");
        usersDaos.addUser(usersItem);

        AddPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddDescriptionOfThing.class);
                startActivity(intent);



            }
        });
        setUpRecyclerView();

    }
    public void initViews(){
        AddPost = findViewById(R.id.floatingActionButton);
    }
    private void setUpRecyclerView() {
        //PostDaos postDaos = new PostDaos();
        //CollectionReference postCollections = postDaos.postCollection;

        Query query = postCollection.orderBy("createdAt", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<PostsItems> options = new FirestoreRecyclerOptions.Builder<PostsItems>()
                .setQuery(query, PostsItems.class)
                .build();

        adapter = new PostAdapter(options,this);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_post);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }


}