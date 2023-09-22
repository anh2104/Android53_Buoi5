package com.example.android53_buoi5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    Context mcontext;
    List<User> mListUsers;

    public UserAdapter(List<User> ListUsers) {
        this.mListUsers = ListUsers;
    }

    @NonNull
    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.mcontext = parent.getContext();
        View view = LayoutInflater.from(mcontext).inflate(R.layout.layout_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUsers.get(position);
        holder.tvUserName.setText(user.getUserName());
        holder.tvInfo.setText("Age : " + user.getAge() + " | Email : " + user.getEmail() + " | Adds : " + user.getAddress());
        Glide.with(mcontext).load(user.getAvatar()).into(holder.imgAvatar);

    }

    @Override
    public int getItemCount() {
        return mListUsers != null? mListUsers.size() : 0;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView tvUserName;
        TextView tvInfo;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvInfo = itemView.findViewById(R.id.tvInfo);
        }
    }
}
