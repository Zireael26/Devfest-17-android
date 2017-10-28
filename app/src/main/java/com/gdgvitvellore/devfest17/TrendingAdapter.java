package com.gdgvitvellore.devfest17;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.twitter.sdk.android.tweetui.TweetView;

import java.util.ArrayList;
import java.util.List;


/**
 * Author: Shuvam Ghosh
 * Created on 9/17/2017
 */
public class TrendingAdapter extends android.support.v7.widget.RecyclerView.Adapter<TrendingAdapter.ViewHolder> {
    List<Long> mDataList;
    private Context mContext;
    private ClickListener clickListener;

    public TrendingAdapter(Context context, ArrayList<Long> tweets) {

        this.mDataList = tweets;
        this.mContext = context;
        /*this.mContext = context;
        this.mDataList = dataList;*/
    }


    @Override
    public ViewHolder onCreateViewHolder(android.view.ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trending_item_view, parent, false);
        ViewHolder vh = new ViewHolder(itemView);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        //TODO: add your code


        Log.v("exc", mDataList.get(position) + "");

       /* TweetUtils.loadTweet(mDataList.get(position), new Callback<Tweet>() {
            @Override
            public void success(Result<Tweet> result) {
                holder.tweetView.removeAllViews();
                holder.tweetView.addView(new TweetView(mContext, result.data));
            }

            @Override
            public void failure(TwitterException exception) {
                Log.e("failed", "Sign in failure", exception);
            }
        });
*/


    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public interface ClickListener {
        void onClick(View view, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TweetView tweetView;
        public ViewHolder(View itemView) {
            super(itemView);
            tweetView = itemView.findViewById(R.id.city_hall_tweet);


        }
    }

}
