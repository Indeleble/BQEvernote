package com.gcv.bqevernote.utils;


import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.gcv.bqevernote.R;

public class CustomDialog extends DialogFragment {

    public interface CustomDialogOnResultListener {
        void onNoteCreatedResult(String title, String content);
    }

    private EditText title;
    private EditText content;
    private Button cancelButton;
    private Button saveButton;
    private CustomDialogOnResultListener listener;

    public CustomDialog() {
    }

    public static CustomDialog newInstance() {

        CustomDialog frag = new CustomDialog();
        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.new_note_layout, container);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        title = (EditText) view.findViewById(R.id.edittext_note_title);
        content = (EditText) view.findViewById(R.id.edittext_note_content);

        cancelButton = (Button) view.findViewById(R.id.button_cancel);
        saveButton = (Button) view.findViewById(R.id.button_save);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog.this.dismiss();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNoteCreatedResult(title.getText().toString(), content.getText().toString());
                CustomDialog.this.dismiss();
            }
        });

    }

    public void setOnNoteCreatedListener(CustomDialogOnResultListener listener) {
        this.listener = listener;
    }
}