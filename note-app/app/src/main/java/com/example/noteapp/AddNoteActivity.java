package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AddNoteActivity extends AppCompatActivity {

    TextView textViewNoteTitle;
    TextView textViewNoteDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        textViewNoteTitle = findViewById(R.id.text_view_note_title);
        textViewNoteDescription = findViewById(R.id.text_view_note_description);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        String description = bundle.getString("description");

        textViewNoteTitle.setText(title);
        textViewNoteDescription.setText(description);
    }
}