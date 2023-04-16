package com.example.hackathon_httpclienterror_400.avtorize.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import com.example.hackathon_httpclienterror_400.avtorize.presentation.AvtorizeViewModel;
import com.example.hackathon_httpclienterror_400.databinding.AvtorizeFragmentBinding;
import com.example.hackathon_httpclienterror_400.feature.register.presentation.RegisterViewModel;

public class AvtorizeFragment extends Fragment {

    private AvtorizeViewModel viewModel;
    private RegisterViewModel viewModelReg;
    private AvtorizeFragmentBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(AvtorizeViewModel.class);
        binding = AvtorizeFragmentBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState == null) {
            viewModel.load();
            if(viewModel.checkUserList(viewModelReg.__users__, viewModelReg.currentUser)){
                Toast.makeText(getContext(), "Вы вошли", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getContext(), "Данные введены неверно", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
