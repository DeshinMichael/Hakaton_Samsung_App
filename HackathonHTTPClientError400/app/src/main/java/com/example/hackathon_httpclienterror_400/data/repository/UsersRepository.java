package com.example.hackathon_httpclienterror_400.data.repository;

import com.example.hackathon_httpclienterror_400.data.api.users.UsersApiService;
import com.example.hackathon_httpclienterror_400.domain.User;

import java.util.List;

import retrofit2.Call;

public class UsersRepository {

    public static Call<List<User>> getUsers(){
        return UsersApiService.getInstance().getUsers();
    }

    public static Call<User> addUser(User user){
        return UsersApiService.getInstance().addUser(user);
    }

    public static Call<User> updateUser(User user){
        return UsersApiService.getInstance().updateUser(user);
    }
}
