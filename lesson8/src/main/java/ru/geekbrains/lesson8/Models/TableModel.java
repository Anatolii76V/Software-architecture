package ru.geekbrains.lesson8.Models;

import ru.geekbrains.lesson8.Presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {
    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null) {
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }
        return tables;
    }

    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(tableNo, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    @Override
    public boolean changeReservation(int reservationNo, Date newReservationDate, int newTableNo, String newName) {
        for (Table table : tables) {
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == reservationNo) {
                    reservation.setDate(newReservationDate);
                    reservation.setTableNo(newTableNo);
                    reservation.setName(newName);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean cancelReservation(int reservationNo) {
        for (Table table : tables) {
            Reservation reservationToRemove = null;
            for (Reservation reservation : table.getReservations()) {
                if (reservation.getId() == reservationNo) {
                    reservationToRemove = reservation;
                    break;
                }
            }
            if (reservationToRemove != null) {
                table.getReservations().remove(reservationToRemove);
                return true;
            }
        }
        return false;
    }
}
