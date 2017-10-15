package com.gdgvitvellore.devfest17;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private RecyclerView parentRecycler;
    private List<Event> data;

    public EventAdapter(List<Event> data) {
        this.data = data;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        parentRecycler = recyclerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_event_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int iconTint = ContextCompat.getColor(holder.itemView.getContext(), R.color.grayIconTint);
        Event event = data.get(position);
        holder.imageView.setImageResource(event.getEventLineDrawable());
//        Glide.with(holder.itemView.getContext())
//                .load(event.getEventLineDrawable())
//                .listener(new TintOnLoad(holder.imageView, iconTint))
//                .into(holder.imageView);
        holder.textView.setText(event.getEventTime());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.event_line_drawable);
            textView = itemView.findViewById(R.id.event_time);

            itemView.findViewById(R.id.container).setOnClickListener(this);
        }

        public void showText() {
            int parentHeight = ((View) imageView.getParent()).getHeight();
            float scale = (parentHeight - textView.getHeight()) / (float) imageView.getHeight();
            imageView.setPivotX(imageView.getWidth() * 0.5f);
            imageView.setPivotY(0);
            imageView.animate().scaleX(scale)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            textView.setTextColor(Color.BLACK);
                            imageView.setColorFilter(Color.BLACK);
                            textView.setTextSize(16);
                        }
                    })
                    .scaleY(scale).setDuration(150)
                    .start();
        }

        public void hideText() {
            int parentHeight = ((View) imageView.getParent()).getHeight();
            float scale = (parentHeight - textView.getHeight()) / (float) imageView.getHeight();
            imageView.setPivotX(imageView.getWidth() * 0.5f);
            imageView.setPivotY(0);
            imageView.animate().scaleX(scale)
                    .withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            textView.setTextColor(ContextCompat.getColor(imageView.getContext(), R.color.grayIconTint));
                            imageView.setColorFilter(ContextCompat.getColor(imageView.getContext(), R.color.grayIconTint));
                            textView.setTextSize(12);
                        }
                    })
                    .scaleY(scale).setDuration(150)
                    .start();
        }

        @Override
        public void onClick(View v) {
            parentRecycler.smoothScrollToPosition(getAdapterPosition());
        }
    }

}
