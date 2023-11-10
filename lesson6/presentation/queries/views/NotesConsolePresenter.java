package ru.geekbrains.lesson6.presentation.queries.views;

import ru.geekbrains.lesson6.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.domain.Note;

import java.util.Collection;

public class NotesConsolePresenter implements NotesPresenter {
    @Override
    public void printAll(Collection<Note> notes) {
        for (Note note : notes){
            System.out.println(note);
        }
    }

    // Добавление нового метода для вывода количества заметок
    public void printNoteCount(int count) {
        System.out.println("Общее количество заметок: " + count);
    }
}
