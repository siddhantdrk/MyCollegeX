package com.example.mycollegex.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycollegex.activity.ContactSellerActivity;
import com.example.mycollegex.activity.MainActivity;
import com.example.mycollegex.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.example.mycollegex.models.PostsItems;

public class PostAdapter extends FirestoreRecyclerAdapter<PostsItems,PostAdapter.PostViewHolder> {






    public PostAdapter(@NonNull FirestoreRecyclerOptions options, MainActivity mainActivity) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull PostsItems model) {

        holder.postNameText.setText(model.getCreatedBy().getDisplayName());

        //Utils util = new Utils();
       // DocumentSnapshot snapshot = getSnapshots().getSnapshot(holder.getAdapterPosition());
        holder.likeCount.setText(model.getCreatedBy().getContactNumber());
        holder.descriptionText.setText(model.getText());
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
       // String currentUserId = currentUser.getUid();
        holder.favouriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });



    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,
                parent, false);
        return new PostViewHolder(v);
    }
    static class PostViewHolder extends RecyclerView.ViewHolder{
        TextView postNameText ;
        TextView descriptionText;
        TextView likeCount;
        ImageView postImage;
        ImageButton favouriteButton;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postNameText = itemView.findViewById(R.id.nameProduct);
            favouriteButton = itemView.findViewById(R.id.favouriteButton);
            likeCount = itemView.findViewById(R.id.countFav);
            descriptionText = itemView.findViewById(R.id.descriptionProduct);
            postImage = itemView.findViewById(R.id.imageProduct);
        }
    }

}
