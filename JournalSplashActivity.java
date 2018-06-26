package com.journalapp.samuel.journalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JournalSplashActivity extends AppCompatActivity {
    int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journal_splash);
        executeProgress();
    }

/**
This method is used for keeping the screen on hold for some seconds and opens the login screen when done
*/

    private void executeProgress() {

        new Thread(new Runnable() {
            public void run() {
                while (status < 100) {
                    status += 5;

                    try {

                        Thread.sleep(200);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Intent intent = new Intent(JournalSplashActivity.this,LoginScreenActivity.class);
                startActivity(intent);

            }
        }).start();
    }

}
