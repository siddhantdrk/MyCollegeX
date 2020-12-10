package com.example.mycollegex.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycollegex.R;
import com.example.mycollegex.activity.ContactSellerActivity;
import com.example.mycollegex.activity.MainActivity;
import com.example.mycollegex.models.PostsItems;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PostAdapter extends FirestoreRecyclerAdapter<PostsItems,PostAdapter.PostViewHolder> {


    Context context;



    public PostAdapter(@NonNull FirestoreRecyclerOptions options, MainActivity mainActivity,Context context1) {
        super(options);

        this.context = context1;

    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull PostsItems model) {

        holder.postNameText.setText(model.getCreatedBy().getDisplayName());

        if (position % 3 == 0) {
            holder.postImage.setImageResource(R.drawable.laptop);
        } else if (position % 3 == 1) {
            holder.postImage.setImageResource(R.drawable.book);
        } else {
            holder.postImage.setImageResource(R.drawable.cooler);
        }
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

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContactSellerActivity.class);
                context.startActivity(intent);
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
        LinearLayout linearLayout;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postNameText = itemView.findViewById(R.id.nameProduct);
            favouriteButton = itemView.findViewById(R.id.favouriteButton);
            likeCount = itemView.findViewById(R.id.countFav);
            descriptionText = itemView.findViewById(R.id.descriptionProduct);
            postImage = itemView.findViewById(R.id.imageProduct);
            linearLayout = itemView.findViewById(R.id.itemGrp);
        }
    }

}
