package ru.geekbrains.lesson8;

import ru.geekbrains.lesson8.Models.TableModel;
import ru.geekbrains.lesson8.Presenters.BookingPresenter;
import ru.geekbrains.lesson8.Presenters.Model;
import ru.geekbrains.lesson8.Views.BookingView;

import java.util.Date;

public class Program {
    public static void main(String[] args) {
        Model model = new TableModel();
        BookingView view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTables();

        // Example usage:
        view.reservationTable(new Date(), 3, "Станислав");
        view.changeReservationTable(1001, new Date(), 2, "Станислав");
    }
}

