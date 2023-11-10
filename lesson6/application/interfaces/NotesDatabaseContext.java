package ru.geekbrains.lesson6.application.interfaces;

import ru.geekbrains.lesson6.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();
    boolean saveChanges();


}
