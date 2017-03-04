package com.gcv.bqevernote.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.evernote.client.android.EvernoteSession;
import com.evernote.client.android.login.EvernoteLoginFragment;
import com.gcv.bqevernote.R;

public class MainActivity extends AppCompatActivity implements EvernoteLoginFragment.ResultCallback {

    Button loginButton;
    final EvernoteSession mEvernoteSession = EvernoteSession.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TO-DO mEvernoteSession.authenticate(MainActivity.this);
                Intent intent_1 = new Intent(MainActivity.this, NotesActivity.class);
                startActivity(intent_1);
            }
        });
    }

    @Override
    public void onLoginFinished(boolean successful) {
        if (successful) {
            // handle success
            Toast.makeText(this, "oleeeeeeeeeeeeeeee", Toast.LENGTH_SHORT).show();
            Intent intent_1 = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intent_1);

        } else {
            // handle failure
            Toast.makeText(this, "noooooooooooo", Toast.LENGTH_SHORT).show();
        }

    }
}
