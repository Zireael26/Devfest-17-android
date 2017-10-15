package com.gdgvitvellore.devfest17;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FAQFragment extends Fragment {

    private View rootView;

    public FAQFragment() {
        // Required empty public constructor
    }

    public static FAQFragment newInstance() {
        return new FAQFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_faq, container, false);
 
        // TODO 1. Add code of FAQ Activity to this fragment
        // TODO 2. Add code from activity_FAQ to fragment_FAQ
        // TODO 3. Add all other xml files normally

        // Put all code from onCreate() of activity here

        // add rest of the code normally

        // for any method that requires context or this, replace that with rootView.getContext()
        // change all findViewById() to rootView.findViewById()

        return rootView;
    }

}
