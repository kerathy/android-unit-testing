package com.example.noteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstActivity extends AppCompatActivity {

    Button button;
    EditText editTextNoteTitle;
    EditText editTextNoteDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        button = findViewById(R.id.add_note_btn);
        editTextNoteTitle = findViewById(R.id.edit_text_note_title);
        editTextNoteDescription = findViewById(R.id.edit_text_note_description);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, AddNoteActivity.class);
                String title = editTextNoteTitle.getText().toString();
                String description = editTextNoteDescription.getText().toString();

                intent.putExtra("title", title);
                intent.putExtra("description", description);

                startActivity(intent);
            }
        });

    }
}