package HW4;

import java.util.Date;
import java.util.UUID;

public class Ticket {

    private int id;
    private int customerId;
    private Date date;
    private String qrcode;
    private boolean enable = true;

    // Конструктор класса
    public Ticket(int id, int customerId, Date date) {
        this.id = id;
        this.customerId = customerId;
        this.date = date;
        this.qrcode = generateQRCode(); // Генерируем QR-код при создании билета
    }

    public Ticket() {

    }

    // Генерация уникального QR-кода
    private String generateQRCode() {
        // Используем класс UUID для генерации уникального идентификатора
        return UUID.randomUUID().toString();
    }

    // Методы доступа к полям
    public int getId() {
        return id;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getQrcode() {
        return qrcode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }
}
