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

        faqList.add(new FAQ("When is the event?", "The event will commence at 7 PM on 28th October.",
                R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("Where is the event?", "Venue details will be up soon, they will also" +
                " be forwarded to all participants via mail and SMS on their registered mobile" +
                " numbers.", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("Who can participate?", "Only freshers can participate in the Ideathon." +
                " The Hackathon is open to all, however, a participant can only participate in one" +
                " of those two events.", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("Can I switch between events?", "Yes, if you feel the pace isn’t for" +
                " you, you can switch either from the Hackathon to the Ideathon or vice-versa up" +
                " until 12 AM. However, you are allowed to switch only once. You can’t go back" +
                " after switching, so be careful before deciding.", R.drawable.ic_ques_white_48dp,
                R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What do I need?", "The participants are expected to carry their" +
                " laptops to the event.", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("Are there any rules?", "Adhere to our Code of Conduct and Rules and" +
                " Regulations while you participate in the event.", R.drawable.ic_ques_white_48dp,
                R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("Do I need a team?", "Yes, you would be working in a team of minimum" +
                " 2 members and maximum 3 members. You may come with your friends as a team, or" +
                " you can team up with other participants at the event. You will however, need to" +
                " get registered as a team member before the problem statements are handed out.",
                R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What are problem statements?", "Problem statements are a description" +
                " of the issues you will be working on. Multiple problem statements will be given" +
                " across domains, and your team can choose to work on any one of them. Each problem" +
                " will have 2 parts, a management part and a technical part.",
                R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("I am at the event. What do I do?", "Got your team? Great! Brainstorm" +
                " and come up with an idea to be presented to our mentor team. When they visit you" +
                " to hear out your idea and plan of action, they will provide you with suggestions." +
                " You can brainstorm across multiple domains, but your final idea should" +
                " correspond to only one domain. Avoid switching ideas because it may lead to you" +
                " falling behind.", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("I have started working on an idea. Now what?", "Start working on" +
                " making a model for your idea. You don’t necessarily need to code, but it is" +
                " accepted nonetheless. Mentors will assist you with your implementation, clarify" +
                " your doubts as well as point out the potential mistakes you might make. They’re" +
                " there to help, don’t be shy, ask your doubts away.", R.drawable.ic_ques_white_48dp,
                R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("How do I go about making a model of my idea?", "You would be required" +
                " to work on building a complete model, including the management and technical" +
                " aspects of the problem.", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What do you mean by management aspect?", "The management part would include \n" +
                "●\tthe description of your solution,\n" +
                "●\tthe resources you would require, \n" +
                "●\tyour optimization measures for your business model and your execution method. \n" +
                "For starters, methods of optimization would include doing a SWOT or Cost-Benefit " +
                "analysis of your model.", R.drawable.ic_ques_white_48dp, R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What do you mean by technical aspect?", "The technical part would" +
                " describe \n" +
                "●\tapproach used to solve the problem\n" +
                "●\tthe technologies you would use in the model\n" +
                "●\tthe methods of their implementation\n" +
                "●\talternative measures and technologies available\n", R.drawable.ic_ques_white_48dp,
                R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("What are the Judging parameters?", "A team comprising of GDG members" +
                " will evaluate your performance according to the criteria mentioned in the Rules " +
                "of Ideathon (which will be provided to you) and declare the results. The top teams would be " +
                "selected to pitch their idea the next evening in front of a panel of judges who" +
                " will decide the eventual winner.", R.drawable.ic_ques_white_48dp,
                R.drawable.ic_ans_white_48dp));
        faqList.add(new FAQ("I still don't see what I was looking for..\nHelp",
                "If you need any assistance you can write to us at gdgvitvellore@gmail.com" +
                        " or approach any of our coordinators present during the event. All the" +
                        " best, and happy brainstorming!", R.drawable.ic_ques_white_48dp,
                R.drawable.ic_ans_white_48dp));


        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());

        faqRecyclerView.setLayoutManager(layoutManager);
        faqRecyclerView.setHasFixedSize(true);

        adapter = new FAQAdapter(rootView.getContext(), faqList);
        faqRecyclerView.setAdapter(adapter);

        return rootView;
    }

}
