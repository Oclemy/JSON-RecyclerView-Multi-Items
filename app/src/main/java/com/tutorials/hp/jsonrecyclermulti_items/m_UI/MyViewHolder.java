package com.tutorials.hp.jsonrecyclermulti_items.m_UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tutorials.hp.jsonrecyclermulti_items.R;

/**
 * Created by Oclemy on 7/13/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView nameTxt,emailTxt,usernameTxt;

    public MyViewHolder(View itemView) {
        super(itemView);

        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        emailTxt= (TextView) itemView.findViewById(R.id.emailTxt);
        usernameTxt= (TextView) itemView.findViewById(R.id.usernameTxt);

    }
}
