package com.gdgvitvellore.devfest17;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimelineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimelineFragment extends Fragment implements DiscreteScrollView.ScrollStateChangeListener<EventAdapter.ViewHolder>,
        DiscreteScrollView.OnItemChangedListener<EventAdapter.ViewHolder>,
        View.OnClickListener {

    private List<Event> events;

    private EventView eventView;
    private DiscreteScrollView timelineEventPicker;

    private View rootView;

    public TimelineFragment() {
        // Required empty public constructor
    }


    public static TimelineFragment newInstance() {
        return new TimelineFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_timeline, container, false);
        eventView = (EventView) rootView.findViewById(R.id.event_detail_view);

        events = TimelineEventList.get().getEvents();
        timelineEventPicker = (DiscreteScrollView) rootView.findViewById(R.id.timeline_event_picker);
        timelineEventPicker.setSlideOnFling(true);
        timelineEventPicker.setClickable(true);
        timelineEventPicker.setAdapter(new EventAdapter(events));
        timelineEventPicker.addOnItemChangedListener(this);
        timelineEventPicker.addScrollStateChangeListener(this);
        timelineEventPicker.setItemTransitionTimeMillis(50);
        timelineEventPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        eventView.setEvent(events.get(0));
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onCurrentItemChanged(@Nullable EventAdapter.ViewHolder holder, int position) {
        //viewHolder will never be null, because we never remove items from adapter's list
        if (holder != null) {
            eventView.setEvent(events.get(position));
            holder.showText();
        }
    }

    @Override
    public void onScrollStart(@NonNull EventAdapter.ViewHolder holder, int position) {
        holder.hideText();
    }

    @Override
    public void onScroll(
            float position,
            int currentIndex, int newIndex,
            @Nullable EventAdapter.ViewHolder currentHolder,
            @Nullable EventAdapter.ViewHolder newHolder) {
        Event current = events.get(currentIndex);
        if (newIndex >= 0 && newIndex < timelineEventPicker.getAdapter().getItemCount()) {
            Event next = events.get(newIndex);
            eventView.onScroll(1f - Math.abs(position));
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onScrollEnd(@NonNull EventAdapter.ViewHolder holder, int position) {

    }

}

