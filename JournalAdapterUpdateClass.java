package com.journalapp.samuel.journalapp.model_class;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.journalapp.samuel.journalapp.R;

import java.util.ArrayList;

/**
 * Created by SAMUEL on 6/27/2018.
 */

public class JournalAdapterUpdateClass extends RecyclerView.Adapter<JournalAdapterUpdateClass.JournalViewHolderUpdate> {
    private ArrayList<JournalObjectClass> journalListUpdate;
    JournalObjectClass journalObjectClass;

    @Override
    public JournalViewHolderUpdate onCreateViewHolder(ViewGroup parent, int viewType) {
Context context = parent.getContext();
int lay_id = R.layout.list_of_thoughts;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachImmediately = false;
        View view = inflater.inflate(lay_id,parent,shouldAttachImmediately);
        JournalViewHolderUpdate journalViewHolderUpdate = new JournalViewHolderUpdate(view);
        return journalViewHolderUpdate;
    }

    @Override
    public void onBindViewHolder(JournalViewHolderUpdate holder, int position) {
        journalListUpdate = new ArrayList<>();
journalObjectClass = new JournalObjectClass();
journalObjectClass = journalListUpdate.get(position);
holder.journal_thoughts_title.setText(journalObjectClass.getThought_title());
holder.journal_thoughts_description.setText(journalObjectClass.getThought_quick_descr());
holder.journal_thoughts_contents.setText(journalObjectClass.getThought_content());
holder.journal_thoughts_date.setText(journalObjectClass.getThought_date());
    }

    @Override
    public int getItemCount() {
        return journalListUpdate.size();
    }


    public class JournalViewHolderUpdate extends RecyclerView.ViewHolder{

        TextView journal_thoughts_title;
        TextView journal_thoughts_description;
        TextView journal_thoughts_date;
        MultiAutoCompleteTextView journal_thoughts_contents;



        public JournalViewHolderUpdate(View itemView) {
            super(itemView);
            journal_thoughts_title = (TextView)itemView.findViewById(R.id.text_view_journal_title);
            journal_thoughts_description = (TextView)itemView.findViewById(R.id.text_view_journal_descrip);
            journal_thoughts_date = (TextView)itemView.findViewById(R.id.text_view_journal_date);
            journal_thoughts_contents = (MultiAutoCompleteTextView)itemView.findViewById(R.id.multi_auto_compl_text_view_journal_content);


        }
    }

}
