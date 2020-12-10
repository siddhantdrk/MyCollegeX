package com.example.mycollegex.models;

public class PostsItems {
    String text = "";
    UsersItem createdBy ;
    long createdAt = 0L;
    //List<String> LikedBy = new ArrayList<>();

    public PostsItems(String text, UsersItem createdBy, long createdAt) {
        this.text = text;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
       // LikedBy = likedBy;
    }

    public PostsItems() {
    }

    public String getText() {
        return text;
    }

    public UsersItem getCreatedBy() {
        return createdBy;
    }

    public long getCreatedAt() {
        return createdAt;
    }


    public void setText(String text) {
        this.text = text;
    }

    public void setCreatedBy(UsersItem createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }


}
