package com.journalapp.samuel.journalapp.database_class;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by SAMUEL on 6/28/2018.
 */

public class FireBaseConnectionClass {

   FirebaseDatabase database ;
    DatabaseReference rootRef ;
    DatabaseReference journal_root;

    public FireBaseConnectionClass(){
        database = FirebaseDatabase.getInstance();
    }

    public DatabaseReference getRootDatabase(){
        rootRef = database.getReference().child("root");
        journal_root = rootRef.child("journal_data");
        return journal_root;

    }


}
