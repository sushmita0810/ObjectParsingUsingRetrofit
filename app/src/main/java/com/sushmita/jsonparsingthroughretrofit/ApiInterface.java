package com.sushmita.jsonparsingthroughretrofit;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

public interface ApiInterface {
    @GET("/mypostedtruck1.php")
    public void getUsersList(Callback<List<UserResponse>> callback);

}
