package ru.geekbrains.lesson6;

import ru.geekbrains.lesson6.application.ConcreteNoteEditor;
import ru.geekbrains.lesson6.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.infrastructure.persistance.Database;
import ru.geekbrains.lesson6.infrastructure.persistance.DatabaseContext;
import ru.geekbrains.lesson6.presentation.queries.controllers.NotesController;
import ru.geekbrains.lesson6.presentation.queries.views.NotesConsolePresenter;

public class Program {

    /**
     * CQRS
     * @param args
     */
    public static void main(String[] args) {
        Database database = new NotesDatabase();
        NotesDatabaseContext context = new DatabaseContext(database);
        NotesConsolePresenter notesConsolePresenter = new NotesConsolePresenter();
        NoteEditor noteEditor = new ConcreteNoteEditor(notesConsolePresenter, context);

        NotesController notesController = new NotesController(noteEditor);

        notesController.routeGetAll();

        // Вызов метода для вывода количества заметок
        notesController.routeCountNotes();
    }
}
