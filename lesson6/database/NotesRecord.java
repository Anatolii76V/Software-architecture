package ru.geekbrains.lesson6.database;

public class NotesRecord {

    private static int counter = 10000;
    private int id;
    private String title;
    private String details;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public NotesRecord(String title, String details) {
        this.title = title;
        this.details = details;
        id = ++counter;
    }


}
