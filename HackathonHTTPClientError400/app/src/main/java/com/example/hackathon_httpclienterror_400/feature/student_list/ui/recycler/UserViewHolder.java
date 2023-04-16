package com.example.hackathon_httpclienterror_400.feature.student_list.ui.recycler;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hackathon_httpclienterror_400.databinding.ItemUserBinding;
import com.example.hackathon_httpclienterror_400.domain.User;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private final ItemUserBinding binding;
    private final UserClickListener listener;

    public UserViewHolder(ItemUserBinding binding, UserClickListener listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void bind(User item) {
        Glide.with(binding.getRoot()).load(item.getPhotoUrl()).into(binding.image);
        binding.name.setText(item.getName());
        binding.email.setText(item.getEmail());
        binding.getRoot().setOnClickListener(v -> listener.onClick(item.getId()));
    }
}
