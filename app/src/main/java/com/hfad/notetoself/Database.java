package com.hfad.notetoself;

import java.util.ArrayList;

public class Database {

    private static ArrayList<Note> notes;

    private static void load()
    {
        notes = new ArrayList<Note>();
        notes.add(new Note("Important", "Mom Birthday", "Mom's birthday is on the 13th"));
        notes.add(new Note("Idea", "New Character", "Make a new dnd character for Gabby's game"));
        notes.add(new Note("To-do", "Errands", "Pick up groceries at landis"));
        notes.add(new Note("Important", "World Peace", "The world should be peaceful"));
        notes.add(new Note("Idea", "Canine Suffrage", "Dogs should be able to vote"));
        notes.add(new Note("To-do", "Study", "Study for biology"));
        notes.add(new Note("Important", "Overwatch 2", "It's a game Sam likes"));
        notes.add(new Note("Idea", "Ohio", "Ohio should secede from the union" ));
        notes.add(new Note("To-do", "Homework", "Tell Sam to do his homework"));
        notes.add(new Note("Idea", "Phones", "Phone should have headphone jacks again"));
    }

    public static ArrayList<Note> getData()
    {
        if (notes == null)
        {
            load();
        }
        return notes;
    }

}
