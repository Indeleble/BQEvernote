package com.gcv.bqevernote;

import android.app.Application;

import com.evernote.client.android.EvernoteSession;



public class BQEvernoteApp extends Application {

    private static final String CONSUMER_KEY = "guillermocasasv";
    private static final String CONSUMER_SECRET = "c8bed3a4498047e7";
    private static final EvernoteSession.EvernoteService EVERNOTE_SERVICE = EvernoteSession.EvernoteService.SANDBOX;
    private static final boolean SUPPORT_APP_LINKED_NOTEBOOKS = true;

    public EvernoteSession evernoteSession;

    @Override
    public void onCreate() {
        super.onCreate();

        //Set up the Evernote singleton session, use EvernoteSession.getInstance() later
        new EvernoteSession.Builder(this)
                .setEvernoteService(EVERNOTE_SERVICE)
                .setSupportAppLinkedNotebooks(SUPPORT_APP_LINKED_NOTEBOOKS)
                .setForceAuthenticationInThirdPartyApp(true)
                .build(CONSUMER_KEY, CONSUMER_SECRET)
                .asSingleton();
        evernoteSession = EvernoteSession.getInstance();
    }
}