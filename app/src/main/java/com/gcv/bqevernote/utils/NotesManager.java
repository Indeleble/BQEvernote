package com.gcv.bqevernote.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.gcv.bqevernote.R;
import com.gcv.bqevernote.model.BQNote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NotesManager {

    final ListView listView;
    Activity activity;
    ArrayAdapter<BQNote> adapter;
    List<BQNote> notes = new ArrayList<>();

    public NotesManager(ListView listView, Activity activity) {

        this.activity = activity;
        this.listView = listView;

        mockNotes();

        adapter = new ArrayAdapter<>(activity,
                android.R.layout.simple_list_item_1, android.R.id.text1, notes);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                loadNote(position);
            }
        });
    }

    private void loadNote(int position) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);
        dialogBuilder.setTitle(notes.get(position).getTitle());
        dialogBuilder.setMessage(notes.get(position).getContent());
        dialogBuilder.setCancelable(true);

        dialogBuilder.setPositiveButton(
                R.string.cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = dialogBuilder.create();
        alert11.show();
    }

    public void sortNotesAlphabetically() {

        Collections.sort(notes, new Comparator<BQNote>() {
            @Override
            public int compare(BQNote s1, BQNote s2) {
                return s1.getTitle().compareTo(s2.getTitle());
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void sortNotesByDate() {
        Collections.sort(notes, new Comparator<BQNote>() {
            public int compare(BQNote m1, BQNote m2) {
                return m1.getDate().compareTo(m2.getDate());
            }
        });
        adapter.notifyDataSetChanged();
    }

    private void mockNotes() {

        for (int i = 0; i < 15; i++) {
            notes.add(new BQNote());
        }
    }

    public void addNote(String title, String content) {
        notes.add(new BQNote(title, content));
    }
}

