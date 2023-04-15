package com.example.hackathon_httpclienterror_400.data.api.users;

import com.example.hackathon_httpclienterror_400.domain.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface UsersApi {

    @GET("user")
    Call<List<User>> getUsers();

    @POST("user")
    Call<User> addUser(@Body User user);

    @PUT("user")
    Call<User> updateUser(@Body User user);
}
