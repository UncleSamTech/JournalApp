package com.journalapp.samuel.journalapp;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.journalapp.samuel.journalapp.model_class.JournalNavBehaviorClass;

public class JournalMainActivity extends AppCompatActivity implements PenItDownFragment.OnFragmentInteractionListener, ListOfThoughtsFragment.OnFragmentInteractionListener,UpdateDeleteThoughtFragment.OnFragmentInteractionListener {
Context context = JournalMainActivity.this;
private String mErrorMessage = "Error as a result of :";
Toast toast;
    BottomNavigationView navigation;
    private ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_main);
        toolbar = getSupportActionBar();
        try{
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);}
        catch(NullPointerException nu){
           toast =  Toast.makeText(context,mErrorMessage,Toast.LENGTH_SHORT);
           toast.show();
        }

        toolbar.setTitle(getString(R.string.msg_label_thoughts_write));
        loadFragment(new PenItDownFragment());

         navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation_id);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new JournalNavBehaviorClass());
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                int id  = item.getItemId();
                switch (id){
                    case R.id.item_write_thoughts:
                        toolbar.setTitle(getString(R.string.msg_label_thoughts_write));
                        fragment = new PenItDownFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.item_list_of_thougts:
                        toolbar.setTitle(getString(R.string.msg_label_thoughts_list_screen));
                        fragment = new ListOfThoughtsFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.item_list_update_delete:
                        toolbar.setTitle(getString(R.string.msg_label_thoughts_update_delete_screen));
                        fragment = new UpdateDeleteThoughtFragment();
                        loadFragment(fragment);
                        return true;
                }
                return false;
            }
        });

    }





    @Override
    public void onFragmentInteraction(Uri uri) {

    }






    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_lay_container_id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
