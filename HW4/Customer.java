package HW4;

import java.util.ArrayList;
import java.util.Collection;

public class Customer {

    private static int counter;
    private final int id;
    private Collection<Ticket> tickets;

    // Конструктор класса
    public Customer() {
        this.id = ++counter;
        this.tickets = new ArrayList<>();
    }

    // Получить список билетов клиента
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    // Установить список билетов клиента
    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }

    // Добавить билет клиенту
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    // Удалить билет у клиента
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    // Обработать покупку билета для клиента
    public void processTicketPurchase(Ticket ticket) {
        addTicket(ticket); // Добавляем билет клиенту
        ticket.setEnable(true); // Устанавливаем билету статус "активный"
    }

    // Метод для получения идентификатора клиента
    public int getId() {
        return id;
    }
}
