package HW4;

import java.util.Collection;
import java.util.Date;

public class Program {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     * <p>
     * 1.  Предусловия.
     * 2.  Постусловия.
     * 3.  Инвариант.
     * 4.  Определить абстрактные и конкретные классы.
     * 5.  Определить интерфейсы.
     * 6.  Реализовать наследование.
     * 7.  Выявить компоненты.
     * 8.  Разработать Диаграмму компонент использую нотацию UML 2.0. Общая без деталей.
     */
    public static void main(String[] args) {
        // Создаем экземпляр класса Core
        Core core = new Core();

        // Создаем экземпляр класса MobileApp
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider());

        // Создаем экземпляр класса Customer
        Customer customer = core.getCustomerProvider().getCustomer("login", "password");

        // Показываем список билетов клиента перед покупкой
        System.out.println("Список билетов клиента до покупки:");
        displayTickets(customer.getTickets());



// Покупаем билет
        boolean purchaseStatus = mobileApp.buyTicket("1234567890");

        // Если покупка прошла успешно, обновляем список билетов клиента
        if (purchaseStatus) {
            System.out.println("Покупка билета прошла успешно.");
            mobileApp.searchTicket(new Date()); // Выполняем поиск билетов на текущую дату
            System.out.println("Обновленный список билетов клиента:");
            displayTickets(customer.getTickets()); // Отображаем обновленный список билетов
        } else {
            System.out.println("Ошибка при покупке билета.");
        }
    }

    // Метод для отображения списка билетов
    private static void displayTickets(Collection<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            System.out.println("Билет ID: " + ticket.getId() + ", QR-код: " + ticket.getQrcode());
        }
    }
}