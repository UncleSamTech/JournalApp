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
         mAuth = FirebaseAuth.getInstance();
        mProgressBar = new ProgressDialog(RegistrationScreenActivity.this);

       getButton(R.id.button_sign_up_id).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               checkEmptyParam();
           }
       });

    }
    
    
      private EditText getEditText(int id){
        EditText editText = findViewById(id);
        return editText;
    }

    private Button getButton(int id){
        Button button = findViewById(id);
        return button;
    }
    
     private void checkEmptyParam(){
        Resources resources = new Resources();
        if(resources.userName.equals("") && resources.passWord.equals("")){
            Toast.makeText(context,getString(R.string.error_empty_params),Toast.LENGTH_SHORT).show();
        }
        else{
            signUpNewUser();
        }
    }
    
    
    private void signUpNewUser(){
        Resources resources = new Resources();
        mProgressBar.show();
        mProgressBar.setMessage(getString(R.string.msg_registration_progress));
        mAuth.createUserWithEmailAndPassword(resources.userName, resources.passWord).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
           if(task.isSuccessful()){
mProgressBar.dismiss();
               Toast.makeText(context,getString(R.string.msg_reg_sucessful), Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(context,LoginScreenActivity.class);
               startActivity(intent);

           }
           else{
               Toast.makeText(context,getString(R.string.error_registration_failes), Toast.LENGTH_SHORT).show();
           }

            }
        });
    }

    private class Resources{
        String userName = getEditText(R.id.edit_text_email_reg_id).getText().toString().trim();
        String passWord = getEditText(R.id.edit_text_pass_reg_id).getText().toString().trim();



        public Resources(){}

    }


}
