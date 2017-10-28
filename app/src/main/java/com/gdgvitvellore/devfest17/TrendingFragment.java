package com.gdgvitvellore.devfest17;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.tweetui.CompactTweetView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class TrendingFragment extends Fragment {


    private static final String TWITTER_KEY = "r8AmjQZ8hA9uyTdq2yNTL0pVa";
    private static final String TWITTER_SECRET = "orvzvJOadXsPKseaRNzuIHGmul2v7JKB3nsJIS7hcIdMgDptTG";
    public String JSON_URl = "http://devfest.tech:8081/twitter";
    View v;
    RecyclerView recView;
    ProgressBar pbar;
    RecyclerView.LayoutManager lm;
    TrendingAdapter ta;
    ArrayList<Long> tweets;
    JSONParseForTweets jsonTweets;
    ArrayList<Long> tweetsIds;



    public TrendingFragment() {
        // Required empty public constructor
    }

    public static TrendingFragment newInstance() {
        return new TrendingFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TwitterConfig config = new TwitterConfig.Builder(context)
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET))
                .build();


        Twitter.initialize(config);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_trending, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        pbar = v.findViewById(R.id.trendingProgress);
        pbar.setVisibility(View.VISIBLE);

        tweets = new ArrayList<>();
        tweetsIds = new ArrayList<>();


        //  sendRequest();
        //jsonTweets = new JSONParseForTweets(v.getContext());


        recView = (RecyclerView)v.findViewById(R.id.recView);
        lm = new LinearLayoutManager(v.getContext());

        new getData().execute();

    }


  /*  private void sendRequest() {

        HttpURLConnection

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
    }*/


    public class getData extends AsyncTask<String, String, String> {

        HttpURLConnection urlConnection;
        JSONArray statusesArray;


        @Override
        protected String doInBackground(String... args) {

            StringBuilder result = new StringBuilder();


            try {
                URL url = new URL(JSON_URl);


                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }


            return result.toString();
        }

        @Override
        protected void onPostExecute(String result) {


            Log.d("Json response xxxx", result);

            try {
                JSONObject jsonObj = new JSONObject(result);
                statusesArray = jsonObj.getJSONArray("statuses");
            } catch (JSONException e) {
                e.printStackTrace();
            }


            // JSONArray jsonArray = new JSONArray();

           /* try {
                jsonArray = new JSONArray(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }*/

            Log.d("Json array is", "" + statusesArray.length());

            for (int i = 0; i < statusesArray.length(); i++) {
                try {
                    tweetsIds.add(statusesArray.getJSONObject(i).getLong("id"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < tweetsIds.size(); i++) {
                Log.d("" + tweetsIds.size(), ": " + tweetsIds.get(i));
            }


            //Do something with the JSON string

            recView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recView.setAdapter(new TrendinggAdapter());
        }

    }

    private class TrendinggAdapter extends RecyclerView.Adapter<TrendinggViewHolder> {

        @Override
        public TrendinggViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_item_view, parent, false);
            TrendinggViewHolder t = new TrendinggViewHolder(v);
            return t;
        }

        @Override
        public void onBindViewHolder(final TrendinggViewHolder holder, int position) {
            Log.v("exc", tweetsIds.get(position) + "");


        }

        @Override
        public int getItemCount() {
            return tweetsIds.size();
        }
    }

    private class TrendinggViewHolder extends RecyclerView.ViewHolder {
        CompactTweetView tweetview;

        public TrendinggViewHolder(View itemView) {
            super(itemView);
            this.tweetview = (CompactTweetView) itemView.findViewById(R.id.city_hall_tweet);
        }
    }
}
