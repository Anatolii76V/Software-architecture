package HW4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TicketProvider {

    private final Database database;
    private final PaymentProvider paymentProvider;

    // Конструктор класса
    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    // Поиск билетов по идентификатору клиента и дате
    // Предусловия: clientId не должен быть равен 0, date не должен быть равен null
    // Работа: Поиск билетов в базе данных по заданным параметрам
    // Постусловия: Возвращает коллекцию билетов, соответствующих критериям
    public Collection<Ticket> searchTicket(int clientId, Date date) {
        assert clientId != 0 && date != null : "Неверный идентификатор клиента или дата";
        Collection<Ticket> tickets = new ArrayList<>();
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getCustomerId() == clientId && ticket.getDate().equals(date)) {
                tickets.add(ticket);
            }
        }
        return tickets;
    }

    // Покупка билета для клиента с использованием номера карты
    // Предусловия: clientId и cardNo не должны быть равны null
    // Работа: Создание заказа на билет в базе данных и выполнение платежа
    // Постусловия: Возвращает true, если покупка билета прошла успешно
    public boolean buyTicket(int clientId, String cardNo) {
        assert clientId != 0 && cardNo != null : "Неверный идентификатор клиента или номер карты";
        int orderId = database.createTicketOrder(clientId);
        double amount = database.getTicketAmount();
        return paymentProvider.buyTicket(orderId, cardNo, amount);
    }

    // Проверка билета по QR-коду
    // Предусловия: qrcode не должен быть равен null
    // Работа: Поиск билета в базе данных по заданному QR-коду и установка его статуса "неактивный"
    // Постусловия: Возвращает true, если билет валиден и успешно обработан
    public boolean checkTicket(String qrcode) {
        assert qrcode != null : "Неверный QR-код";
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                ticket.setEnable(false);
                // Сохранение изменений в базе данных ...
                return true;
            }
        }
        return false;
    }
}
