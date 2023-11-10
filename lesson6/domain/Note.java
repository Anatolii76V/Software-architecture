package ru.geekbrains.lesson6.domain;

public class Note {


    //region Constructors

    public Note(int id, String title, String details) {
        this.id = id;
        this.title = title;
        this.details = details;
    }

    //endregion

    //region Properties

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    //endregion

    //region Fields
    private int id;
    private String title;
    private String details;

    //endregion

    @Override
    public String toString() {
        return String.format("%s %s", title, details);
    }

}
