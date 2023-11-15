package ru.geekbrains.lesson8.Presenters;

import ru.geekbrains.lesson8.Models.TableModel;
import ru.geekbrains.lesson8.Views.BookingView;

import java.util.Date;

public class BookingPresenter implements ViewObserver {
    private final Model model;
    private final View view;

    public BookingPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.registerObserver(this);
    }

    public void updateTables() {
        view.showTables(model.loadTables());
    }

    private void showReservationTableResult(int reservationNo) {
        view.showReservationTableResult(reservationNo);
    }

    @Override
    public void onReservationTable(Date reservationDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(reservationDate, tableNo, name);
            showReservationTableResult(reservationNo);
        } catch (RuntimeException e) {
            showReservationTableResult(-1);
        }
    }

    public boolean changeReservationTable(int reservationNo, Date newReservationDate, int newTableNo, String newName) {
        boolean success = model.changeReservation(reservationNo, newReservationDate, newTableNo, newName);
        if (success) {
            view.showReservationTableResult(reservationNo);
            return true;
        } else {
            view.showReservationTableResult(-1);
            return false;
        }
    }

    public boolean cancelReservation(int reservationNo) {
        boolean canceled = model.cancelReservation(reservationNo);
        if (canceled) {
            view.showReservationTableResult(reservationNo);
            return true;
        } else {
            view.showReservationTableResult(-1);
            return false;
        }
    }
}
