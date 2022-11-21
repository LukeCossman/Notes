package com.hfad.notetoself;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpRecyclerView();

        FloatingActionButton btnAdd = findViewById(R.id.fab);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                DialogAddNote dialog = new DialogAddNote();
                dialog.show(manager, "");
            }
        });


    }

    private void setUpRecyclerView()
    {
        RecyclerView rv = findViewById(R.id.recycler_view);

        NoteAdapter adapter = new NoteAdapter(getSupportFragmentManager(), Database.getData());
        rv.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv.setLayoutManager(layoutManager);

    }

}