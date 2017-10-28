package com.gdgvitvellore.devfest17;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventView extends LinearLayout {

    private TextView eventDescription;
    private TextView eventName;
    private ImageView eventImage;

    {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER_HORIZONTAL);
        inflate(getContext(), R.layout.view_event, this);

        eventDescription = findViewById(R.id.event_description);
        eventImage = findViewById(R.id.event_image);
        eventName = findViewById(R.id.event_name);
        eventDescription.setTextAlignment(TEXT_ALIGNMENT_CENTER);
    }

    public EventView(Context context) {
        super(context);
    }

    public EventView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EventView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EventView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setEvent(Event event) {
        Timeline timeline = event.getEventTitle();
        eventDescription.setText(timeline.getDisplayName());
        eventName.setText(event.getEventDescription());
        eventImage.setImageResource(timelineToIcon(timeline));
//        Glide.with(getContext()).load(timelineToIcon(timeline)).into(eventImage);
//        invalidate();

        eventImage.animate()
                .scaleX(1f).scaleY(1f)
                .setInterpolator(new AccelerateDecelerateInterpolator())
                .setDuration(50)
                .start();
    }

    public void onScroll(float fraction) {
        eventImage.setScaleX(fraction);
        eventImage.setScaleY(fraction);
        invalidate();
    }

    private int timelineToIcon(Timeline timeline) {
        switch (timeline) {
            case D11:
                return R.drawable.liftoff;
            case D12:
                return R.drawable.speaker;
            case D13:
                return R.drawable.hack;
            case D14:
                return R.drawable.pizza;
            case D21:
                return R.drawable.fries;
            case D22:
                return R.drawable.pitch;
            case D23:
                return R.drawable.hack;
            case D24:
                return R.drawable.chicken_dinner;
            case D25:
                return R.drawable.registration;
            case D26:
                return R.drawable.liftoff;
            case D27:
                return R.drawable.pitch;
            case D28:
                return R.drawable.speaker;
            case D29:
                return R.drawable.prizes;
            default:
                throw new IllegalArgumentException();
        }
    }

}
