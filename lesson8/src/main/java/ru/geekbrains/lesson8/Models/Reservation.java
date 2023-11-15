package ru.geekbrains.lesson8.Models;

import java.util.Date;

public class Reservation {

    public Reservation(int tableNo, Date date, String name) {
        this.tableNo = tableNo;
        this.date = date;
        this.name = name;
    }

    private static int counter = 1000;
    private final int id;

    private int tableNo;
    private Date date;
    private String name;

    {
        id = ++counter;
    }

    public int getId() {
        return id;
    }

    public int getTableNo() {
        return tableNo;
    }

    public void setTableNo(int tableNo) {
        this.tableNo = tableNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
