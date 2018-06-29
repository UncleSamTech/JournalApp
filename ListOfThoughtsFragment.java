package com.journalapp.samuel.journalapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.journalapp.samuel.journalapp.model_class.JournalAdapterClass;
import com.journalapp.samuel.journalapp.model_class.JournalObjectClass;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListOfThoughtsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListOfThoughtsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListOfThoughtsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private ArrayList<JournalObjectClass> journal_list;
    private JournalObjectClass journal_object_class;
    private JournalAdapterClass journal_adapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ListOfThoughtsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListOfThoughtsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListOfThoughtsFragment newInstance(String param1, String param2) {
        ListOfThoughtsFragment fragment = new ListOfThoughtsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        
    }
    
      View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        try{
             v = inflater.inflate(R.layout.fragment_list_of_thoughts, container, false);
            journal_list = new ArrayList<>();
            recyclerView = v.findViewById(R.id.recycle_view_thought_list_id);
            layoutManager = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
        
            journal_adapter = new JournalAdapterClass(journal_list);
            recyclerView.setAdapter(journal_adapter);



            journal_list.add(new JournalObjectClass("My feelings", "my feelings are so real", "06th july 1998","Contenrs are simple"));
            journal_list.add(new JournalObjectClass("My feelings", "my feelings are so real", "06th july 1998", "cant say the contents now"));
            journal_adapter.notifyDataSetChanged();
        }catch(NullPointerException nux){
            Toast.makeText(getContext(),getString(R.string.error_unable_pop_view) + nux.getMessage(),Toast.LENGTH_SHORT).show();
        }
        // Inflate the layout for this fragment
        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
