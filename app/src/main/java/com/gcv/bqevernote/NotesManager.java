package com.gcv.bqevernote;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;

public class NotesManager {

    final ListView listView;
    Activity activity;
    ArrayAdapter<String> adapter;
    List<String> values = new ArrayList<>();

    public NotesManager(ListView listView, Activity activity) {

        this.activity = activity;
        this.listView = listView;

        values.add("");
        values.add("Nota de test 1");
        values.add("Nota de test 2");
        values.add("Nota de test 3");

        adapter = new ArrayAdapter<>(activity,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

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

    public void updateList(List<String> values) {

        adapter.clear();
        values.add("");
        adapter.addAll(values);
        adapter.notifyDataSetChanged();

    }
}

