package com.sushmita.jsonparsingthroughretrofit;

import retrofit.RestAdapter;

public class Api {
    public static ApiInterface getClient(){
        //change the base url
        RestAdapter adapter= new RestAdapter.Builder()
                .setEndpoint("https://www.onnway.com/android/")
                .build();
        ApiInterface api=adapter.create(ApiInterface.class);
        return api;
    }
}
