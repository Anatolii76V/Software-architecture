package HW4;

import java.util.ArrayList;
import java.util.Collection;

public class Database {

    private static int counter;
    private Collection<Ticket> tickets = new ArrayList<>(); // коллекция билетов
    private Collection<Customer> customers = new ArrayList<>(); // коллекция клиентов

    public Database() {
        Ticket ticket1 = new Ticket(); // создаем первый билет
        Ticket ticket2 = new Ticket(); // создаем второй билет

        tickets.add(ticket1); // добавляем первый билет в коллекцию
        tickets.add(ticket2); // добавляем второй билет в коллекцию

        Customer customer1 = new Customer(); // создаем первого клиента
        customer1.getTickets().add(ticket1); // добавляем первый билет клиенту

        Customer customer2 = new Customer(); // создаем второго клиента
        customer2.getTickets().add(ticket2); // добавляем второй билет клиенту

        customers.add(customer1); // добавляем первого клиента в коллекцию
        customers.add(customer2); // добавляем второго клиента в коллекцию

        // Добавляем еще трех клиентов с по одному билету для каждого
        for (int i = 0; i < 3; i++) {
            Customer customer = new Customer(); // создаем нового клиента
            Ticket ticket = new Ticket(); // создаем новый билет
            tickets.add(ticket); // добавляем билет в коллекцию
            customer.getTickets().add(ticket); // добавляем билет клиенту
            customers.add(customer); // добавляем клиента в коллекцию
        }
    }

    // Возвращает коллекцию билетов
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    // Возвращает коллекцию клиентов
    public Collection<Customer> getCustomers() {
        return customers;
    }

    // Возвращает стоимость билета
    public double getTicketAmount() {
        return 55;
    }

    // Создает и возвращает идентификатор заказа на покупку билета
    public int createTicketOrder(int clientId) {
        return ++counter;
    }

}
