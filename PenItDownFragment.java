package com.journalapp.samuel.journalapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.journalapp.samuel.journalapp.database_class.FireBaseConnectionClass;
import com.journalapp.samuel.journalapp.model_class.JournalObjectClass;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PenItDownFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PenItDownFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PenItDownFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FireBaseConnectionClass fireBaseConnectionClass;
    ProgressDialog pDialog;
    JournalObjectClass journalObjectClass;
    Resources resources;
    Bundle bundle;
    Intent intent;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PenItDownFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PenItDownFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PenItDownFragment newInstance(String param1, String param2) {
        PenItDownFragment fragment = new PenItDownFragment();
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
        pDialog = new ProgressDialog(getContext());
        getButton(R.id.img_btn_pen_down_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmptyParam();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pen_it_down, container, false);
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
    private EditText getEditText(int id){
        View view = new View(getContext());
        EditText editText = view.findViewById(id);
        return editText;
    }

    private Button getButton(int id){
        View view = new View(getContext());
        Button button = view.findViewById(id);
        return button;
    }

    private MultiAutoCompleteTextView getMultiTextView(int id){
        View view = new View(getContext());
        MultiAutoCompleteTextView multiAutoCompleteTextView = view.findViewById(id);
        return multiAutoCompleteTextView;
    }

    boolean editStatus;
    private void checkEmptyParam() {
        Resources res = new Resources();
        if (res.journal_title.equals("") && res.jornal_descrip.equals("") && res.journal_content.equals("")) {
            Toast.makeText(getContext(), "Oops Seems You've not  not supplied any parameter yet", Toast.LENGTH_SHORT).show();
            editStatus = false;
        }
        else {
            pushToDatabase();
        }

    }

    private class Resources{
        String journal_title = getEditText(R.id.edit_text_thought_title_id).getText().toString().trim();
        String jornal_descrip = getEditText(R.id.edit_text_thought_descript).getText().toString().trim();
        String journal_content = getMultiTextView(R.id.multi_auto_complete_journal_content_id).getText().toString().trim();

        public Resources(){}


    }

    private void pushToDatabase(){

        pDialog.setMessage(getString(R.string.msg_saving_journal_progress));
        pDialog.show();
        fireBaseConnectionClass = new FireBaseConnectionClass();
resources = new Resources();
String key  = fireBaseConnectionClass.getRootDatabase().push().getKey();


        journalObjectClass = new JournalObjectClass(resources.journal_title,resources.journal_content,resources.jornal_descrip,"09/06/2018");

fireBaseConnectionClass.getRootDatabase().child(key).setValue(journalObjectClass);
pDialog.dismiss();
        

    }

    

}
