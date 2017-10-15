package com.gdgvitvellore.devfest17;

import java.util.Arrays;
import java.util.List;

public class TimelineEventList {


    private TimelineEventList() {
    }

    public static TimelineEventList get() {
        return new TimelineEventList();
    }

    public List<Event> getEvents() {
        return Arrays.asList(
// Dxy denotes Day x, Event Y
                new Event("7 PM", R.drawable.line_drawable_liftoff, "Opening speech and introduction", Timeline.D11),
                new Event("7:30 PM", R.drawable.line_drawable_speaker, "Speech by Speaker 1", Timeline.D12),
                new Event("8 PM", R.drawable.line_drawable_hack, "Hackathon and Ideathon begins", Timeline.D13),
                new Event("9:30 PM", R.drawable.line_drawable_food, "Dinner Served", Timeline.D14),
                new Event("3 AM", R.drawable.line_drawable_food, "Ideathon Conclusion and Snacks served", Timeline.D21),
                new Event("3:30 AM", R.drawable.line_drawable_pitch, "Pitching for Ideathon Begins", Timeline.D22),
                new Event("6 AM", R.drawable.line_drawable_hack, "Gates Open", Timeline.D23),
                new Event("8 AM", R.drawable.line_drawable_food, "Breakfast", Timeline.D24),
                new Event("12 PM", R.drawable.line_drawable_registration, "Hack Conclusion Alert Call", Timeline.D25),
                new Event("1 PM", R.drawable.line_drawable_liftoff, "Hack Concludes\nFirst Call for Pitch Submission", Timeline.D26),
                new Event("2 PM", R.drawable.line_drawable_pitch, "Final Call for Pitch Submission\nPitching Starts", Timeline.D27),
                new Event("5 PM", R.drawable.line_drawable_speaker, "Speakers 2 and 3", Timeline.D28),
                new Event("6 PM", R.drawable.line_drawable_prizes, "Results Announcement", Timeline.D29));
    }
}
