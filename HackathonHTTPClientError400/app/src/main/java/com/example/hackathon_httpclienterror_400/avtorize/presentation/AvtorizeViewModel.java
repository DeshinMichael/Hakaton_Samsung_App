package com.example.hackathon_httpclienterror_400.avtorize.presentation;

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

public class AvtorizeViewModel extends ViewModel {

    private final MutableLiveData<List<User>> _users = new MutableLiveData<>();
    public LiveData<List<User>> users = _users;
    public List<User> __users__;
    public User currentUser;

    public void load() {
        UsersRepository.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(@NonNull Call<List<User>> call, @NonNull Response<List<User>> response) {
                _users.setValue(response.body());
                __users__ = response.body();
            }

            @Override
            public void onFailure(@NonNull Call<List<User>> call, @NonNull Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
    public boolean checkUserList(List<User> userList, User new_user) {
        boolean result = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(new_user.getName()) && userList.get(i).getName().equals(new_user.getName())) {
                result = true;
            }
        }
        return result;
    }
}
