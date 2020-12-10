package com.example.mycollegex.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycollegex.MainActivity;
import com.example.mycollegex.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;

import models.PostsItems;

public class PostAdapter extends FirestoreRecyclerAdapter<PostsItems,PostAdapter.PostViewHolder> {




    public PostAdapter(@NonNull FirestoreRecyclerOptions options, MainActivity mainActivity) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull PostsItems model) {

        holder.postText.setText(model.getText());
        holder.userText.setText( model.getCreatedBy().getDisplayName());

        //Utils util = new Utils();
        holder.createdAt.setText(model.getCreatedBy().getCollegeEmail());
       // DocumentSnapshot snapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
       // String currentUserId = currentUser.getUid();



    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,
                parent, false);
        return new PostViewHolder(v);
    }
    class PostViewHolder extends RecyclerView.ViewHolder{
        TextView postText ;
        TextView userText;
        TextView createdAt;
        TextView likeCount;
        ImageView userImage,likeButton;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postText = itemView.findViewById(R.id.post_text);
            userText = itemView.findViewById(R.id.user_name);
            createdAt = itemView.findViewById(R.id.created_At);
            likeButton = itemView.findViewById(R.id.like_button);
            likeCount = itemView.findViewById(R.id.like_count_textview);
            userImage = itemView.findViewById(R.id.user_image);
        }
    }

}
