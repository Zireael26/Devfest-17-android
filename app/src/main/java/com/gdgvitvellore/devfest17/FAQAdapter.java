package com.gdgvitvellore.devfest17;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

/**
 * Created by Raina on 17-10-2017.
 */

class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.QNAViewHolder> {

    private Context mContext;
    private ArrayList<FAQ> faqList;
//    private Typeface quesFont, ansFont;

    FAQAdapter(Context mContext, ArrayList<FAQ> faqList) {
        this.mContext = mContext;
        this.faqList = faqList;
    }

    @Override
    public QNAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutIdForListItem = R.layout.item_faq;
        LayoutInflater inflater = LayoutInflater.from(mContext);

//        quesFont = Typeface.createFromAsset(mContext.getAssets(),  "fonts/Exo2-Regular.ttf");
//        ansFont = Typeface.createFromAsset(mContext.getAssets(),  "fonts/Exo2-Regular.ttf");

        View view = inflater.inflate(layoutIdForListItem, parent, false);

        return new QNAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final QNAViewHolder holder, int position) {
        holder.quesText.setText(faqList.get(position).getQuestion());
//        holder.quesText.setTypeface(quesFont);
        holder.quesIcon.setImageResource(faqList.get(position).getQuesIcon());
        holder.ansText.setText(faqList.get(position).getAnswer());
//        holder.ansText.setTypeface(ansFont);
        holder.ansIcon.setImageResource(faqList.get(position).getAnsIcon());

        if (holder.faqItem.isBackSide())
            holder.faqItem.flipTheView(false);


        holder.faqItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.faqItem.flipTheView();
            }
        });
        holder.frontLayout.setBackgroundResource(faqList.get(position).getCardBackground());
        holder.backLayout.setBackgroundResource(faqList.get(position).getCardBackground());
    }

    @Override
    public int getItemCount() {
        return faqList.size();
    }

    class QNAViewHolder extends RecyclerView.ViewHolder {
        TextView quesText, ansText;
        ImageView ansIcon, quesIcon;
        EasyFlipView faqItem;
        LinearLayout backLayout, frontLayout;

        QNAViewHolder(View view) {
            super(view);
            quesText = view.findViewById(R.id.questionText);
            ansText = view.findViewById(R.id.answerText);
            ansIcon = view.findViewById(R.id.ansIcon);
            quesIcon = view.findViewById(R.id.quesIcon);
            faqItem = view.findViewById(R.id.faq_item);
            backLayout = view.findViewById(R.id.faq_card_back_layout);
            frontLayout = view.findViewById(R.id.faq_card_front_layout);
        }
    }

}
