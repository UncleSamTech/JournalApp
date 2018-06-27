package com.journalapp.samuel.journalapp.model_class;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.journalapp.samuel.journalapp.R;

import java.util.ArrayList;

/**
 * Created by SAMUEL on 6/26/2018.
 */

public class JournalAdapterClass extends RecyclerView.Adapter<JournalAdapterClass.JournalViewHolder> {
    JournalObjectClass journalObjectClass;
    private ArrayList<JournalObjectClass> journalList;
    int numItemsList;

    public JournalAdapterClass(ArrayList<JournalObjectClass> journalList) {
        this.journalList = journalList;
        this.numItemsList = numItemsList;
    }

    @Override
    public JournalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int id = R.layout.list_of_thoughts;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachImmediately = false;
        View view = inflater.inflate(id,parent,shouldAttachImmediately);
        JournalViewHolder journalViewHolder = new JournalViewHolder(view);

        return journalViewHolder;
    }

    @Override
    public void onBindViewHolder(JournalViewHolder holder, int position) {
       journalObjectClass = new JournalObjectClass();
       journalObjectClass = journalList.get(position);
       holder.journal_thoughts_title.setText(journalObjectClass.getThought_title());
       holder.journal_thoughts_description.setText(journalObjectClass.getThought_quick_descr());
       holder.journal_thoughts_date.setText(journalObjectClass.getThought_date());


    }

    @Override
    public int getItemCount() {
        return numItemsList;
    }

    public class JournalViewHolder extends RecyclerView.ViewHolder{

            TextView journal_thoughts_title;
            TextView journal_thoughts_description;
            TextView journal_thoughts_date;



        public JournalViewHolder(View itemView) {
            super(itemView);
            journal_thoughts_title = (TextView)itemView.findViewById(R.id.text_view_journal_title);
            journal_thoughts_description = (TextView)itemView.findViewById(R.id.text_view_journal_descrip);
            journal_thoughts_date = (TextView)itemView.findViewById(R.id.text_view_journal_date);

        }
    }
}
