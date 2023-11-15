package ru.geekbrains.lesson8.Views;

import ru.geekbrains.lesson8.Models.Table;
import ru.geekbrains.lesson8.Presenters.BookingPresenter;
import ru.geekbrains.lesson8.Presenters.View;
import ru.geekbrains.lesson8.Presenters.ViewObserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class BookingView implements View {
    private Collection<ViewObserver> observers = new ArrayList<>();

    @Override
    public void registerObserver(ViewObserver observer) {
        observers.add(observer);
    }

    @Override
    public void showTables(Collection<Table> tables) {
        for (Table table : tables) {
            System.out.println(table);
        }
    }

    @Override
    public void showReservationTableResult(int reservationNo) {
        if (reservationNo > 0)
            System.out.printf("Столик успешно забронирован. Номер бронирования #%d\n", reservationNo);
        else
            System.out.println("Не удалось зарезервировать столик.\nПожалуйста, повторите попытку позже.");
    }

    public void reservationTable(Date reservationDate, int tableNo, String name) {
        for (ViewObserver observer : observers)
            observer.onReservationTable(reservationDate, tableNo, name);
    }

    public boolean changeReservationTable(int oldReservation, Date newReservationDate, int newTableNo, String newName) {
        boolean success = false;
        for (ViewObserver observer : observers) {
            success = ((BookingPresenter) observer).changeReservationTable(oldReservation, newReservationDate, newTableNo, newName);
        }
        return success;
    }

    public boolean cancelReservation(int reservationNo) {
        boolean canceled = false;
        for (ViewObserver observer : observers) {
            canceled = ((BookingPresenter) observer).cancelReservation(reservationNo);
        }
        return canceled;
    }
}
