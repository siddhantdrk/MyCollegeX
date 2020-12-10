package com.example.mycollegex.DbHandles;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import com.example.mycollegex.models.UsersItem;

public class UsersDaos {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference usersCollection = db.collection("users");

    public void addUser(UsersItem users){
        if(users!=null){

            usersCollection.document(users.getUid()).set(users);

        }
    }

    public Task<DocumentSnapshot> getUserById(String uid) {
         return  usersCollection.document(uid).get();
    }
}
