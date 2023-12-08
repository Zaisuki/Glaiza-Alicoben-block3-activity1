package com.alicoben.glaiza.block3.p1.quiz;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Notes extends AppCompatActivity {

    private EditText noteTitle, inputSub, inputNote;
    private TextView Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        noteTitle = findViewById(R.id.noteTitle);
        inputSub = findViewById(R.id.inputSub);
        inputNote = findViewById(R.id.inputNote);
        Date = findViewById(R.id.Date);

        // Use OnBackPressedCallback to handle the back button press
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Date.setText(new SimpleDateFormat("EEEE, dd MMMM yyyy :mm a", Locale.getDefault()).format(new Date()));
                saveNote();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);

        ImageView backB = findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.handleOnBackPressed();
            }
        });
    }

    private void saveNote() {
        if (noteTitle.getText().toString().trim().isEmpty()) {
            Toast.makeText(Notes.this, "Cannot display empty", Toast.LENGTH_SHORT).show();
            return;
        } else if (inputSub.getText().toString().trim().isEmpty()
                && inputNote.getText().toString().trim().isEmpty()) {
            Toast.makeText(Notes.this, "Cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        final Notes note = new Notes();
        note.setTitle(noteTitle.getText().toString());
        note.setSubtitle(inputSub.getText().toString());
        note.setNoteText(inputNote.getText().toString());
        note.setDate(Date.getText().toString());


    }

    private void setDate(String toString) {
    }

    private void setNoteText(String toString) {
    }

    private void setSubtitle(String toString) {

    }
}



