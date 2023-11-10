package ru.geekbrains.lesson6.presentation.queries.controllers;

import ru.geekbrains.lesson6.application.ConcreteNoteEditor;
import ru.geekbrains.lesson6.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.presentation.queries.controllers.Controller;

public class NotesController extends Controller {

    private final NoteEditor noteEditor;

    public NotesController(NoteEditor noteEditor) {
        this.noteEditor = noteEditor;
    }

    //TODO: \notes\all
    public void routeGetAll() {
        noteEditor.printAll();
    }

    // Новый метод для вывода количества заметок
    public void routeCountNotes() {
        int count = ((ConcreteNoteEditor) noteEditor).countNotes();
        System.out.println("Количество заметок: " + count);
    }
}
