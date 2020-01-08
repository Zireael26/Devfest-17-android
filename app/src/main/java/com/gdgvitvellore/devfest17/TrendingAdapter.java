package com.gdgvitvellore.devfest17;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * Author: Shuvam Ghosh
 * Created on 9/17/2017
 */
public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.ViewHolder> {
    private Context mContext;

    List<TweetModel> mDataList;


    private ClickListener clickListener;

    public TrendingAdapter(Context context,ArrayList<TweetModel> tweets) {

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

        holder.time.setText(mDataList.get(position).getTime().toString());
        holder.tvTitle.setText("Title");
      //  Glide.with(mContext).load(mDataList.get(position).getTweetImageUrl());

        Glide.with(holder.itemView.getContext())
                .load(mDataList.get(position).getTweetImageUrl())
                .into(holder.tweetImage);

        holder.tvtweetContent.setText(mDataList.get(position).getTweetText());


    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView time;
        TextView tvTitle;
        ImageView tweetImage;
        TextView tvtweetContent;


        public ViewHolder(View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.evDateTime);
            tvTitle = itemView.findViewById(R.id.evTitle);
            tweetImage = itemView.findViewById(R.id.evImg);
            tvtweetContent = itemView.findViewById(R.id.tvContent);

            /*tvAccessionNo = itemView.findViewById(R.id.lbl_accession);
            tvName = itemView.findViewById(R.id.lbl_prot_name);
            tvSequence = itemView.findViewById(R.id.lbl_seq);
            tvFullName = itemView.findViewById(R.id.lbl_full_name);*/

        }
    }

    public interface ClickListener {
        void onClick(View view, int position);
    }

}
