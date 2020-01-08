package com.gdgvitvellore.devfest17;

import android.app.Fragment;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;


public class TrendingFragment extends Fragment {


    RecyclerView recView;
    ProgressBar pbar;
    RecyclerView.LayoutManager lm;
    TrendingAdapter ta;
    ArrayList<TweetModel> tweets;
    JSONParseForTweets jsonTweets;

    public String JSON_URl="http://devfest.tech:8081/twitter";


    public TrendingFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_trending,container,false);
        init(v);
        return v;
    }


    public static TrendingFragment newInstance() {
        return new TrendingFragment();
    }

    private void init(View v) {
        pbar = v.findViewById(R.id.trendingProgress);
        pbar.setVisibility(View.VISIBLE);

        tweets = new ArrayList<>();


        sendRequest();
        //jsonTweets = new JSONParseForTweets(v.getContext());


        recView = (RecyclerView)v.findViewById(R.id.recView);
        lm = new LinearLayoutManager(v.getContext());



    }


    private void sendRequest() {

        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(JSON_URl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {

                    pbar.setVisibility(View.INVISIBLE);
                    String arrayResponse = response.toString();
                    Log.v("Response", arrayResponse);
                    JSONParseForTweets jsonParseForTweets=new JSONParseForTweets(arrayResponse);
                    jsonParseForTweets.parseJSON();
                    tweets = (ArrayList<TweetModel>) jsonParseForTweets.getTweetList();

                    ta = new TrendingAdapter(getActivity(),tweets);
                    recView.setLayoutManager(lm);
                    recView.setAdapter(ta);

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

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(jsonArrayRequest);
    }

}
