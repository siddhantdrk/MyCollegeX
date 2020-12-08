package DbHandles;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

import models.PostsItems;
import models.UsersItem;

public class PostDaos {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference postCollection = db.collection("posts");
    FirebaseUser currentUser;

    long currentTime;
    PostsItems post;
    UsersItem users;

    public void addPost(String toPost) {
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if(currentUser!=null){
            UsersDaos usersDao = new UsersDaos();
            Task<DocumentSnapshot> task =  usersDao.getUserById(currentUser.getUid());

            task.addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        users = document.toObject(UsersItem.class);
                        Log.d("TAGUsersDao", "Display name of current user " + users.getDisplayName(), task.getException());
                        currentTime = Calendar.getInstance().getTimeInMillis();
                        post = new PostsItems();
                        post.setText(toPost);
                        post.setCreatedBy(users);
                        post.setCreatedAt(currentTime);
                        postCollection.document().set(post);



                    } else {
                        Log.d("TAGUsersDao", "get failed with ", task.getException());
                    }
                }
            });
        }
        else{ }



    }
    public Task<DocumentSnapshot> getPostById(String PostId){
        return postCollection.document(PostId).get();

    }
}
