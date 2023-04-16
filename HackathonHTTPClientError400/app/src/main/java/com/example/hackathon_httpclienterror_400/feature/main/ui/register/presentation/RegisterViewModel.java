package com.example.hackathon_httpclienterror_400.feature.main.ui.register.presentation;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.hackathon_httpclienterror_400.data.repository.UsersRepository;
import com.example.hackathon_httpclienterror_400.domain.User;
import com.example.hackathon_httpclienterror_400.feature.main.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterViewModel extends ViewModel {

    private final MutableLiveData<List<User>> _users = new MutableLiveData<>();
    public LiveData<List<User>> users = _users;
    public List<User> __users__;


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
        boolean result = true;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getName().equals(new_user.getName())) {

                result = false;
            }

        }
        return result;
    }

    public void send(User user, Context context) {
        if (checkUserList(__users__, user)) {
            UsersRepository.addUser(user).enqueue(new Callback<User>() {
                @Override
                public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                    Toast.makeText(context, "Регистрация пройдена успешно", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {

                }

            });
        }
        else {
            Toast.makeText(context, "Вы не были зарегистрированы", Toast.LENGTH_SHORT).show();
        }
    }
}



