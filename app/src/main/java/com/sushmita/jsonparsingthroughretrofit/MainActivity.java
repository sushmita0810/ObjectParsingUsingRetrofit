package com.sushmita.jsonparsingthroughretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.sushmita.jsonparsingthroughvolley.R;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<UserResponse> userResponses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        getUserListData();
    }

    private  void  getUserListData(){
        final ProgressDialog progressDialog= new ProgressDialog(MainActivity.this);
        progressDialog.setCancelable(false); // set cancelable to false
        progressDialog.setMessage("Please Wait"); // set message
        progressDialog.show(); // show progress dialog

        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // getUsersList() is a method in API Interface class, in this method we define our API sub url
        Api.getClient().getUsersList(new Callback<List<UserResponse>>() {
            @Override
            public void success(List<UserResponse> userListResponses, Response response) {
                // in this method we will get the response from API
                progressDialog.dismiss(); //dismiss progress dialog
                userResponses = userListResponses;
                setDataInRecyclerView(); // call this method to set the data in adapter
            }

            @Override
            public void failure(RetrofitError error) {
                // if error occurs in network transaction then we can get the error in this method.
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                progressDialog.dismiss(); //dismiss progress dialog

            }
        });
    }

    private void setDataInRecyclerView() {
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // call the constructor of UsersAdapter to send the reference and data to Adapter
        UserAdapter usersAdapter = new UserAdapter(MainActivity.this, userResponses);
        recyclerView.setAdapter(usersAdapter); // set the Adapter to RecyclerView
    }
}

