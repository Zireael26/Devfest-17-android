package com.gdgvitvellore.devfest17;


import android.app.Fragment;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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

    public void setUserVisibleHint() {

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
                R.drawable.line_drawable_pitch, R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("Where is the event taking place?", "Venue details will be up soon," +
                " they will also be forwarded to all participants via mail and SMS on their" +
                " registered mobile numbers.", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("Who can participate in the event?", "Only freshers can participate in" +
                " the Ideathon. The Hackathon is open to all, however, a participant can only" +
                " participate in one of those two events.", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("Can I switch between events?", "Yes you can, but only until 12 AM." +
                " You are allowed to switch only once. You can’t go back after switching, so be" +
                " mindful of that fact.", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("What do equipment I need to carry to the Ideathon?", "The participants" +
                " are expected to carry their laptops and chargers to the event along with any " +
                "other equipment you may require.", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("Are there any rules?", "Adhere to our Code of Conduct and Rules and" +
                " Regulations while you participate in the event.", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("Do I need a team?", "Yes, you would be working in a team of minimum " +
                "2 members and maximum 3 members.", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("What are problem statements?", "Problem statements are a description " +
                "of the issues you will be working on. Multiple problem statements will be given " +
                "across domains, and your team can choose to work on any one of them.",
                R.drawable.line_drawable_pitch, R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("What do I do once the problem statements are handed out?", "You have" +
                " to brainstorm with your team and come up with an idea and present it to your " +
                "mentors. They will visit you to hear out your idea and plan of action. They will " +
                "also provide you with suggestions for further course of action.",
                R.drawable.line_drawable_pitch, R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("How many ideas do I have to work on?", "You can brainstorm across" +
                " multiple domains, but your final idea and its corresponding model should " +
                "correspond to only one domain.", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("What happens once we finalize our idea?", "Start working on making" +
                " a model for your idea. Coding is not required, but is accepted nonetheless. " +
                "Mentors will assist you with your implementation, clarify your doubts as well as " +
                "point out the potential mistakes you might make. They’re there to help, so don’t" +
                " be shy about asking your doubts.", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("What will a model of an idea comprise of?", "You would be required " +
                "to work on building a complete model, including the management and technical " +
                "aspects of the problem.\n" +
                "The management part would include the description of your solution, resources," +
                " optimization, among others. The technical part would describe the approach, " +
                "technology used and the like.\n", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("What are the Judging parameters?", "A team comprising of GDG members" +
                " will evaluate your performance according to the criteria mentioned in the Rules" +
                " of Ideathon and then declare the results. The top teams would be selected to " +
                "pitch their idea the next evening in front of a panel of judges who will decide " +
                "the eventual winner.", R.drawable.line_drawable_pitch, R.drawable.ic_ans_white_48dp,
                R.drawable.faq_shape_bg_accent));
        faqList.add(new FAQ("Help", "If you need any assistance you can write to us at " +
                "gdgvitvellore@gmail.com or approach any of our coordinators present during the" +
                " event. All the best, and happy brainstorming!", R.drawable.line_drawable_pitch,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_accent));


        faqList.add(new FAQ("When is the event taking place?", "The event will commence at 7 PM" +
                " on 28th October.", R.drawable.line_drawable_hack, R.drawable.ic_ans_white_48dp,
                R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("Where is the event taking place?", "Venue details will be up soon, " +
                "they will also be forwarded to all participants via mail and SMS on their " +
                "registered mobile numbers.", R.drawable.line_drawable_hack,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("Who can participate in the event?", "Only freshers can participate" +
                " in the Ideathon. The Hackathon is open to all, however, a participant can only" +
                " participate in one of those two events.", R.drawable.line_drawable_hack,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("Can I switch between events?", "Yes you can, but only until 12 AM." +
                " You are allowed to switch only once. You can’t go back after switching, so be " +
                "mindful of that fact.", R.drawable.line_drawable_hack, R.drawable.ic_ans_white_48dp,
                R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("What do equipment I need to carry to the Hackathon?", "The " +
                "participants are expected to carry their laptops and chargers to the event along" +
                " with any other equipment you may require.", R.drawable.line_drawable_hack,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("Are there any rules?", "Adhere to our Code of Conduct and Rules and" +
                " Regulations while you participate in the event.", R.drawable.line_drawable_hack,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("Do I need a team?", "Yes, you would be working in a team of minimum 2" +
                " members and maximum 3 members.", R.drawable.line_drawable_hack,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("What are problem statements?", "Problem statements are a description" +
                " of the issues you will be working on. Multiple problem statements will be given" +
                " across domains, and you can choose to work on any one of them.",
                R.drawable.line_drawable_hack, R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("How do I start working on my problem?", "Understand what the problem " +
                "requires of you. Work with your team to come up with a plan to solve it. You may " +
                "ask our coordinators present for help, and they will assist you the best they can.",
                R.drawable.line_drawable_hack, R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("Will I be provided with food?", "We will be serving dinner," +
                " snacks as well as breakfast during the event.", R.drawable.line_drawable_hack,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("What do I need for the final pitch?", "You will need to make a " +
                "presentation as well as a demo of what you worked on.", R.drawable.line_drawable_hack,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("What are the Judging parameters?", "A judging panel will evaluate" +
                " your performance according to the criteria mentioned in the Rules of Hackathon " +
                "then declare the results.", R.drawable.line_drawable_hack, R.drawable.ic_ans_white_48dp,
                R.drawable.faq_shape_bg_primary));
        faqList.add(new FAQ("Help", "If you need any assistance you can write to us at " +
                "gdgvitvellore@gmail.com or approach any of our coordinators present during the " +
                "event. All the best, and happy hacking!", R.drawable.line_drawable_hack,
                R.drawable.ic_ans_white_48dp, R.drawable.faq_shape_bg_primary));


        LinearLayoutManager layoutManager = new LinearLayoutManager(rootView.getContext());

        faqRecyclerView.setLayoutManager(layoutManager);
        faqRecyclerView.setHasFixedSize(true);

        adapter = new FAQAdapter(rootView.getContext(), faqList);
        faqRecyclerView.setAdapter(adapter);

        return rootView;
    }

}
