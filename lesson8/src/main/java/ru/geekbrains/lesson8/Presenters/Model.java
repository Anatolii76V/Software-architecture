package ru.geekbrains.lesson8.Presenters;

import ru.geekbrains.lesson8.Models.Table;

import java.util.Collection;
import java.util.Date;

public interface Model {
    Collection<Table> loadTables();
    int reservationTable(Date reservationDate, int tableNo, String name);
    boolean changeReservation(int reservationNo, Date newReservationDate, int newTableNo, String newName);
    boolean cancelReservation(int reservationNo);
}

