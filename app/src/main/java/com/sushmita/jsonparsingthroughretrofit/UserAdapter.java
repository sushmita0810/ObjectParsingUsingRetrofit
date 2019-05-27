package com.sushmita.jsonparsingthroughretrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sushmita.jsonparsingthroughvolley.R;

import java.util.List;



public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsersViewHolder> {

    Context context;
    List<UserResponse> userListResponseData;

    public UserAdapter(Context context, List<UserResponse> userListResponseData) {
        this.userListResponseData = userListResponseData;
        this.context = context;
    }

    @Override
    public UsersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_elements, null);
        UsersViewHolder usersViewHolder = new UsersViewHolder(view);
        return usersViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersViewHolder holder, final int position) {
        // set the data
        holder.source.setText("Source: " + userListResponseData.get(position).getSource());
        holder.sch_date.setText("Sch_Date: " + userListResponseData.get(position).getSch_date());
        holder.trucktype.setText("TruckType: "+ userListResponseData.get(position).getTrucktype());
        holder.destination.setText("Destination: "+userListResponseData.get(position).getDestination());
        // implement setONCLickListtener on itemView
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // display a toast with user name
                Toast.makeText(context, userListResponseData.get(position).getSch_date(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userListResponseData.size(); // size of the list items
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView source,sch_date,trucktype,destination;

        public UsersViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            source = (TextView) itemView.findViewById(R.id.source);
            sch_date = (TextView) itemView.findViewById(R.id.sch_date);
            trucktype=(TextView)itemView.findViewById(R.id.trucktype);
            destination=(TextView)itemView.findViewById(R.id.destination);
        }
    }
}
