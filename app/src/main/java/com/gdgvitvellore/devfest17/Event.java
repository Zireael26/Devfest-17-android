package com.gdgvitvellore.devfest17;


public class Event {

    private final String eventTime;
    private final int eventLineDrawable;
    private final String eventDescription;
    private final Timeline eventTitle;

    public Event(String eventTime, int eventLineDrawable, String eventDescription, Timeline eventTitle) {
        this.eventTime = eventTime;
        this.eventLineDrawable = eventLineDrawable;
        this.eventDescription = eventDescription;
        this.eventTitle = eventTitle;
    }

    public String getEventTime() {
        return eventTime;
    }

    public int getEventLineDrawable() {
        return eventLineDrawable;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public Timeline getEventTitle() {
        return eventTitle;
    }
}
