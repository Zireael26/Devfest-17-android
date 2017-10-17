package com.gdgvitvellore.devfest17;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;

/**
 * Created by Raina on 17-10-2017.
 */

public class FAQAdapter extends RecyclerView.Adapter<FAQAdapter.QNAViewHolder> {

    private Context mContext;
    private ArrayList<FAQ> faqList;

    FAQAdapter(Context mContext, ArrayList<FAQ> faqList) {
        this.mContext = mContext;
        this.faqList = faqList;
    }

    @Override
    public QNAViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.faq_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachParentToImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachParentToImmediately);

        return new QNAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final QNAViewHolder holder, int position) {
        holder.quesText.setText(faqList.get(position).getQuestion());
        holder.quesIcon.setImageResource(faqList.get(position).getQuesIcon());
        holder.ansText.setText(faqList.get(position).getAnswer());
        holder.ansIcon.setImageResource(faqList.get(position).getAnsIcon());
        holder.faqItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.faqItem.flipTheView();
            }
        });
    }

    @Override
    public int getItemCount() {
        return faqList.size();
    }

    class QNAViewHolder extends RecyclerView.ViewHolder {
        TextView quesText, ansText;
        ImageView ansIcon, quesIcon;
        EasyFlipView faqItem;

        QNAViewHolder(View view) {
            super(view);
            quesText = (TextView) view.findViewById(R.id.questionText);
            ansText = (TextView) view.findViewById(R.id.answerText);
            ansIcon = (ImageView) view.findViewById(R.id.ansIcon);
            quesIcon = (ImageView) view.findViewById(R.id.quesIcon);
            faqItem = (EasyFlipView) view.findViewById(R.id.faq_item);
        }
    }

}
