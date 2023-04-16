package com.example.hackathon_httpclienterror_400.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;
import com.example.hackathon_httpclienterror_400.R;
import com.example.hackathon_httpclienterror_400.databinding.FragmentProfileBinding;
import com.example.hackathon_httpclienterror_400.domain.User;
import com.example.hackathon_httpclienterror_400.presentation.ProfileViewModel;

public class ProfileFragment extends Fragment {

    private ProfileViewModel viewModel;
    private FragmentProfileBinding binding;
    private ProfileFragmentArgs args;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        args = ProfileFragmentArgs.fromBundle(requireArguments());
        viewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        binding = FragmentProfileBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.user.observe(getViewLifecycleOwner(), this::renderUser);
        binding.toolbar.setNavigationOnClickListener(v ->  Navigation.findNavController(binding.getRoot()).navigateUp());
        if (savedInstanceState == null) viewModel.load(args.getId());
    }

    private void renderUser(User user) {
        binding.image.setImageResource(R.drawable.avatar);
        binding.name.setText(user.getName());
        binding.email.setText("Почта: " + user.getEmail());
        binding.phone.setText("Телефон: " + user.getPhone());
        binding.progress.setText("Прогресс: " + user.getProgress());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
