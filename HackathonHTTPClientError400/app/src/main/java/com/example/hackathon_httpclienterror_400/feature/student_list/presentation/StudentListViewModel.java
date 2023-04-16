package com.example.hackathon_httpclienterror_400.feature.student_list.presentation;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hackathon_httpclienterror_400.data.repository.UsersRepository;
import com.example.hackathon_httpclienterror_400.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentListViewModel extends ViewModel {

    private final MutableLiveData<List<User>> _users = new MutableLiveData<>();
    public LiveData<List<User>> users = _users;

    public void load() {
        UsersRepository.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                _users.setValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
