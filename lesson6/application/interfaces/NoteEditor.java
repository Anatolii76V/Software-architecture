package ru.geekbrains.lesson6.application.interfaces;

import ru.geekbrains.lesson6.domain.Note;

public interface NoteEditor extends Editor<Note, Integer>{

    void printAll();

}
