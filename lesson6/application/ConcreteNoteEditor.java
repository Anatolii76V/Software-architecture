package ru.geekbrains.lesson6.application;

import ru.geekbrains.lesson6.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.domain.Note;

import java.util.Collection;
import java.util.Optional;


// Конкретный редактор заметок
public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext; // контекст базы данных для заметок
    private final NotesPresenter presenter; // демонстратор для вывода заметок

    // Конструктор
    public ConcreteNoteEditor(NotesPresenter presenter, NotesDatabaseContext dbContext) {
        this.dbContext = dbContext;
        this.presenter = presenter;
    }

    // Метод для добавления новой заметки
    @Override
    public boolean add(Note item) {
        // добавление заметки в коллекцию всех заметок
        dbContext.getAll().add(item);
        // сохранение изменений в базе данных
        return dbContext.saveChanges();
    }

    // Метод для редактирования существующей заметки
    @Override
    public boolean edit(Note item) {
        // Логика редактирования заметки
        for (Note note : dbContext.getAll()) {
            if (note.getId() == item.getId()) {
                note.setTitle(item.getTitle());
                note.setDetails(item.getDetails());
                // сохранение изменений в базе данных
                return dbContext.saveChanges();
            }
        }
        return false;
    }

    // Метод для удаления существующей заметки
    @Override
    public boolean remove(Note item) {
        // удаление заметки из коллекции всех заметок
        dbContext.getAll().removeIf(note -> note.getId() == item.getId());
        // сохранение изменений в базе данных
        return dbContext.saveChanges();
    }

    // Метод для получения заметки по её идентификатору
    @Override
    public Optional<Note> getById(Integer integer) {
        // поиск заметки по идентификатору
        for (Note note : dbContext.getAll()) {
            if (note.getId() == integer) {
                return Optional.of(note);
            }
        }
        return Optional.empty();
    }

    // Метод для получения всех заметок
    @Override
    public Collection<Note> getAll() {
        // получение всех заметок из контекста базы данных
        return dbContext.getAll();
    }

    // Метод для вывода всех заметок
    @Override
    public void printAll() {
        // вызов метода демонстратор для вывода всех заметок
        presenter.printAll(getAll());
    }

    // Новый метод для подсчета количества заметок
    public int countNotes() {
        return dbContext.getAll().size();
    }
}
