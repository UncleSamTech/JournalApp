package com.journalapp.samuel.journalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class RegistrationScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_screen);

    }
    
    
      private EditText getEditText(int id){
        EditText editText = findViewById(id);
        return editText;
    }

    private Button getButton(int id){
        Button button = findViewById(id);
        return button;
    }

    private class Resources{
        String userName = getEditText(R.id.edit_text_email_reg_id).getText().toString().trim();
        String passWord = getEditText(R.id.edit_text_pass_reg_id).getText().toString().trim();



        public Resources(){}

    }


}
