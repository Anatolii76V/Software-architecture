package ru.geekbrains.lesson8.Presenters;

import ru.geekbrains.lesson8.Models.Table;

import java.util.Collection;

public interface View {

    void registerObserver(ViewObserver observer);

    void showTables(Collection<Table> tables);

    void showReservationTableResult(int reservationNo);

}
