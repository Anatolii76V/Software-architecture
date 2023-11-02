package HW4;

import java.util.Random;

public class CustomerProvider {

    private final Database database;
    private final Random random;

    public CustomerProvider(Database database) {
        this.database = database;
        this.random = new Random();
    }

    public Customer getCustomer(String login, String password) {
        // Возвращаем случайного клиента из базы данных
        int randomIndex = random.nextInt(database.getCustomers().size());
        return database.getCustomers().stream().skip(randomIndex).findFirst().orElse(null);
    }
}
