package com.journalapp.samuel.journalapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginScreenActivity extends AppCompatActivity {
    Context context = LoginScreenActivity.this;
    Intent intent;
    FirebaseAuth mAuth;
    ProgressDialog progressDialog;
    private Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(context);
        getTextView(R.id.text_view_sign_up_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context,RegistrationScreenActivity.class);
                startActivity(intent);
            }
        });

        getButton(R.id.button_sign_in_id).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkEmptyParams();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }

    public EditText getEditText(int id){
        EditText editText =  findViewById(id);
        return editText;
    }

    public TextView getTextView(int id){
        TextView textView = findViewById(id);
        return textView;
    }

    private Button getButton(int id){
        Button button = findViewById(id);
        return button;
    }

    private void checkEmptyParams(){
        resources = new Resources();
        if(resources.userName.equals("") && resources.passWord.equals("")){
            Toast.makeText(context,getString(R.string.error_empty_params),Toast.LENGTH_SHORT).show();
        }
        else{
            signInUsers();
        }
    }

    private class Resources{
        String userName = getEditText(R.id.edit_text_email_login_id).getText().toString().trim();
        String  passWord = getEditText(R.id.edit_text_pass_login_id).getText().toString().trim();



        public Resources(){}

    }

    private void signInUsers(){
        resources = new Resources();
        progressDialog.setMessage(getString(R.string.msg_signing_in_progress));
        mAuth.signInWithEmailAndPassword(resources.userName,resources.passWord).addOnCompleteListener(LoginScreenActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(context,getString(R.string.msg_login_sucess),Toast.LENGTH_SHORT).show();
                    intent = new Intent(context, JournalMainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(context,getString(R.string.error_msg_email_pass_not_found) + task.getException(),Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
