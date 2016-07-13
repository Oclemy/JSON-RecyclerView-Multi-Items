package com.tutorials.hp.jsonrecyclermulti_items.m_JSON;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tutorials.hp.jsonrecyclermulti_items.m_Model.User;
import com.tutorials.hp.jsonrecyclermulti_items.m_UI.MyAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Oclemy on 7/7/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 * -----------------    ROLES -----------------------
 * 1.RECEIVE DOWNLOADED DATA
 * 2.PARSE IT
 * 3.CALL ADAPTER CLASS TO BIND IT TO CUSTOM RECYCLERVIEW
 */
public class JSONParser extends AsyncTask<Void,Void,Boolean>{

    Context c;
    String jsonData;
    RecyclerView rv;

    ProgressDialog pd;
    ArrayList<User> users=new ArrayList<>();

    public JSONParser(Context c, String jsonData, RecyclerView rv) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return parse();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        pd.dismiss();
        if(isParsed)
        {
            //BIND
            rv.setAdapter(new MyAdapter(c,users));

        }else
        {
            Toast.makeText(c, "Unable To Parse,Check Your Log output", Toast.LENGTH_SHORT).show();
        }
    }

    private Boolean parse()
    {
        try
        {
            JSONArray ja=new JSONArray(jsonData);
            JSONObject jo;

            users.clear();
            User user;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                String name=jo.getString("name");
                String username=jo.getString("username");
                String email=jo.getString("email");

                user=new User();

                user.setName(name);
                user.setUsername(username);
                user.setEmail(email);

                users.add(user);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}



















