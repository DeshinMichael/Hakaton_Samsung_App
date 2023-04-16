package com.example.hackathon_httpclienterror_400.feature.main.ui.register.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.hackathon_httpclienterror_400.R;
import com.example.hackathon_httpclienterror_400.databinding.RegisterFragmentBinding;
import com.example.hackathon_httpclienterror_400.domain.User;
import com.example.hackathon_httpclienterror_400.feature.main.ui.MainActivity;
import com.example.hackathon_httpclienterror_400.feature.main.ui.register.presentation.RegisterViewModel;

public class RegisterFragment extends Fragment {

    private RegisterViewModel viewModel;
    private RegisterFragmentBinding binding;
    public User current_user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(RegisterViewModel.class);
        binding = RegisterFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        current_user = new User(3, binding.nicknameInput.getText().toString(),
                binding.emailInput.getText().toString(), "https://drive.google.com/file/d/1QgBcJ29El9h-PAwIsaWIZQ-VF8-1UW_l/view?usp=sharing",
                binding.phoneInput.getText().toString(), 0);
        if(savedInstanceState == null) {
            viewModel.load();
            viewModel.send(current_user, getContext());
        }

    }
}
