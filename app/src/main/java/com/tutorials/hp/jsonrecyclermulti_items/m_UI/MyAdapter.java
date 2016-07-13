package com.tutorials.hp.jsonrecyclermulti_items.m_UI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutorials.hp.jsonrecyclermulti_items.R;
import com.tutorials.hp.jsonrecyclermulti_items.m_Model.User;

import java.util.ArrayList;

/**
 * Created by Oclemy on 7/13/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 *
 * ---------------------------ROLES-------------------------------
 * | 1.INFLATE MODEL LAYOUT
 * | 2.BIND DATA TO RECYCLERVIEW
 * ----------------------------------------------------------------
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    Context c;
    ArrayList<User> users;

    public MyAdapter(Context c, ArrayList<User> users) {
        this.c = c;
        this.users = users;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        User user=users.get(position);

        holder.nameTxt.setText(user.getName());
        holder.emailTxt.setText(user.getEmail());
        holder.usernameTxt.setText(user.getUsername());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
