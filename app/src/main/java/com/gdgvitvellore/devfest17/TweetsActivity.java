package com.gdgvitvellore.devfest17;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.fabric.sdk.android.services.concurrency.internal.DefaultRetryPolicy;

public class TweetsActivity extends AppCompatActivity {

    public String JSON_URl="http://devfest.tech:8081/twitter";
    List<TweetModel> mDataSet=new ArrayList<TweetModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweets);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        sendRequest();
    }

    private void sendRequest() {

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(JSON_URl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    String arrayResponse = response.toString();
                    Log.v("Response", arrayResponse);
                    JSONParseForTweets jsonParseForTweets=new JSONParseForTweets(arrayResponse);
                    jsonParseForTweets.parseJSON();
                    mDataSet = jsonParseForTweets.getTweetList();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

}
