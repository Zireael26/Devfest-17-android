package com.gdgvitvellore.devfest17;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FAQFragment extends Fragment {

    private View rootView;

    private RecyclerView faqRecyclerView;
    private FAQAdapter adapter;
    private ArrayList<FAQ> faqList = new ArrayList<>();


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

        faqRecyclerView = (RecyclerView) rootView.findViewById(R.id.faq_recycler_view);

        faqList.add(new FAQ("What's a Hack?", "Its the stuff", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What's a Heck?", "Its the nothin", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What's a Hick?", "Its the deal", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What's a Hock?", "Its the deal", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What's a Huck?", "Its the deal", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What's a Hulk?", "Its the green guy", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));

        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());
        faqRecyclerView.setLayoutManager(layoutManager);
        faqRecyclerView.setHasFixedSize(true);

        adapter = new FAQAdapter(rootView.getContext(), faqList);
        faqRecyclerView.setAdapter(adapter);

        return rootView;
    }

}
