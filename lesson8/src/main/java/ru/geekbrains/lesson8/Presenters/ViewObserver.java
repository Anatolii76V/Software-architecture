package ru.geekbrains.lesson8.Presenters;

import java.util.Date;

public interface ViewObserver {

    void onReservationTable(Date reservtionDate, int tableNo, String name);
}
