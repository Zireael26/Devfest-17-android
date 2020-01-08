package com.gdgvitvellore.devfest17;


import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cooltechworks.views.ScratchTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScratchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScratchFragment extends Fragment {

    public static final String MY_PREFS_NAME = "MyPrefsFile";
    public static String CouponKey = "couponKey";
    public SharedPreferences sharedpreferences;
    public SharedPreferences.Editor editor;
    private View rootView;
    private CardView placeholderCardView, afterRevealCardView, scratchCardParentView;
    private TextView keyTextView;
    private ScratchTextView scratchView;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference keyRef = database.getReference("keys");
    private DatabaseReference enabledRef = database.getReference("scratchEnabled");

    public ScratchFragment() {
        // Required empty public constructor
    }

    public static ScratchFragment newInstance() {
        return new ScratchFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_scratch, container, false);

        placeholderCardView = (CardView) rootView.findViewById(R.id.placeHolderView);
        scratchCardParentView = (CardView) rootView.findViewById(R.id.scratchCardParentView);
        scratchView = (ScratchTextView) rootView.findViewById(R.id.scratchView);
        afterRevealCardView = (CardView) rootView.findViewById(R.id.afterRevealCardView);
        keyTextView = (TextView) rootView.findViewById(R.id.keyTextView);

        scratchCardParentView.setVisibility(View.GONE);
        afterRevealCardView.setVisibility(View.GONE);

        enabledRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean isEnabled = dataSnapshot.getValue(Boolean.class);
                if (isEnabled) {
                    placeholderCardView.setVisibility(View.GONE);
                    scratchCardParentView.setVisibility(View.VISIBLE);
                    if (sharedpreferences.getBoolean("revealed", false)) {
                        placeholderCardView.setVisibility(View.GONE);
                        afterRevealCardView.setVisibility(View.VISIBLE);
                        keyTextView.setText(sharedpreferences.getString(CouponKey, ""));
                        scratchCardParentView.setVisibility(View.GONE);
                    }
                } else {
                    placeholderCardView.setVisibility(View.VISIBLE);
                    scratchCardParentView.setVisibility(View.GONE);
                }

                Log.v("isEnabled", "" + isEnabled);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        sharedpreferences = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        if (sharedpreferences.contains(CouponKey)) {
            scratchView.setText(sharedpreferences.getString(CouponKey, ""));
        } else {
            String key = keyRef.push().getKey();//key to be taken from Firebase
            key = key.substring(key.length() - 8, key.length());
            keyRef.child(key).setValue(key);
            keyRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    scratchView.setText(sharedpreferences.getString(CouponKey, ""));
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            editor = sharedpreferences.edit();
            editor.putString(CouponKey, key);
            editor.apply();
        }


        scratchView.setRevealListener(new ScratchTextView.IRevealListener() {
            @Override
            public void onRevealed(ScratchTextView scratchTextView) {

            }

            @Override
            public void onRevealPercentChangedListener(ScratchTextView scratchTextView, float v) {
                if (v > 0.8) {
                    editor = sharedpreferences.edit();
                    editor.putBoolean("revealed", true);
                    editor.apply();
                }
            }
        });

        return rootView;
    }

}
