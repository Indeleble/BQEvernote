package com.gcv.bqevernote;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gcv.bqevernote.model.BQNote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class NotesManager {

    final ListView listView;
    Activity activity;
    ArrayAdapter<String> adapter;
    List<String> values = new ArrayList<>();
    List<BQNote> notes = new ArrayList<>();

    public NotesManager(ListView listView, Activity activity) {

        this.activity = activity;
        this.listView = listView;

        values.add(0, "");

        mockNotes();
        populateValues();

        adapter = new ArrayAdapter<>(activity,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });
    }

    private void populateValues() {

        for (BQNote note : notes) {
            values.add(note.getTitle());
        }
    }

    private void loadNote(int position) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        dialogBuilder.setTitle(values.get(position));
        dialogBuilder.setMessage("Este es el contenido de: " + values.get(position).toLowerCase());
        dialogBuilder.setCancelable(true);

        dialogBuilder.setPositiveButton(
                "Cerrar",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = dialogBuilder.create();
        alert11.show();
    }

    public void sortNotesAlphabetically() {

        Collections.sort(values, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        adapter.notifyDataSetChanged();
    }

    private void mockNotes() {

        for (int i = 0; i < 15; i++) {
            notes.add(new BQNote());
        }
    }

    public static String getRandomString() {

        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(5);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }
}

