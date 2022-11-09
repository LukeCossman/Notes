package com.hfad.notetoself;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private ArrayList<Note> notesList;

    public NoteAdapter(ArrayList<Note> n)
    {
        notesList = n;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_row, parent, false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteAdapter.NoteViewHolder holder, int position) {
        Note n = notesList.get(position);
        holder.setData(n, position);

    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }


    class NoteViewHolder extends RecyclerView.ViewHolder
    {
        private TextView txtStatus;
        private TextView txtTitle;
        private TextView txtText;
        private ImageView imgDelete;
        private int currentPosition = -1;
        private Note currentNote = null;

        public NoteViewHolder(View view)
        {
            super(view);
            txtStatus = view.findViewById(R.id.txt_status);
            txtTitle = view.findViewById(R.id.txt_title);
            txtText = view.findViewById(R.id.txt_text);
            imgDelete = view.findViewById(R.id.img_delete);

            imgDelete.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    notesList.remove(currentPosition);
                    notifyItemRemoved(currentPosition);
                    notifyItemRangeChanged(currentPosition, notesList.size());
                }
            });
        }

        public void setData(Note n, int position)
        {
            txtStatus.setText(n.getStatus());
            txtTitle.setText(n.getTitle());
            txtText.setText(n.getText());
            currentPosition = position;
            currentNote = n;
        }


    }


}
