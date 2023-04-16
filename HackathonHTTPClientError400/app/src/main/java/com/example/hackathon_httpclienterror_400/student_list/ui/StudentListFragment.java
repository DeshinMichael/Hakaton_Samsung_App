package com.example.hackathon_httpclienterror_400.student_list.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.hackathon_httpclienterror_400.databinding.FragmentStudentListBinding;
import com.example.hackathon_httpclienterror_400.domain.User;
import com.example.hackathon_httpclienterror_400.student_list.ui.recycler.UserAdapter;
import com.example.hackathon_httpclienterror_400.student_list.presentation.StudentListViewModel;

import java.util.List;

public class StudentListFragment extends Fragment {
    private StudentListViewModel viewModel;
    private FragmentStudentListBinding binding;
    private UserAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(StudentListViewModel.class);
        binding = FragmentStudentListBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new UserAdapter(id -> Navigation.findNavController(binding.getRoot()).navigate(StudentListFragmentDirections.actionStudentListToProfile(id)));
        binding.recycler.setAdapter(adapter);
        viewModel.users.observe(getViewLifecycleOwner(), this::renderUsers);
        if (savedInstanceState == null) viewModel.load();
    }

    private void renderUsers(List<User> users) {
        adapter.setItems(users);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
