package HW3;

import java.awt.*;


public class Program {
    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объём двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     * <p>
     * 2. Создать конкретный автомобиль путём наследования класса
     * «Car».
     * <p>
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     * <p>
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     * <p>
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     * <p>
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     * <p>
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     * <p>
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     * <p>
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     * <p>
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     * <p>
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     * <p>
     * TODO: Домашнее задание:
     * Доработать приложение, спроектированное на семинаре. Добавить тип, описывающий "автомойку".
     * Продемонстрировать работу получившейся программы,
     * создать несколько типов автомобилей,
     * загнать каждый автомобиль на заправку, а затем и на автомойку.
     *
     * @param args
     */
    public static void main(String[] args) {

        RefuelingStation refuelingStation = new RefuelingStation();
        RefuelingStationV2 refuelingStation2 = new RefuelingStationV2();

        Harvester harvester = new Harvester("A", "B", Color.BLACK);
        harvester.setRefuelingStation(refuelingStation2);
        harvester.fuel();

        // Создание объекта автомойки и добавление цен для разных типов автомобилей
        CarWash carWash = new CarWash(1000.0, 1500.0);
        carWash.setPriceForCarType(CarType.valueOf("Sedan"), 1000.0);
        carWash.setPriceForCarType(CarType.valueOf("SUV"), 1500.0);
        carWash.setPriceForCarType(CarType.valueOf("Harvester"), 2000.0);

        // Создание объектов разных типов автомобилей
        Sedan sedan = new Sedan("Toyota", "Camry", Color.BLUE, CarType.Sedan, GearboxType.AUTOMATIC, 2.5, false);
        SUV suv = new SUV("BMW", "X5", Color.BLACK, CarType.SUV, GearboxType.AUTOMATIC, 3.0, false);
        harvester = new Harvester("A", "B", Color.BLACK);

        // Заправка каждого автомобиля
        sedan.setRefuelingStation(new RefuelingStation());
        sedan.fuel();

        suv.setRefuelingStation(new RefuelingStation());
        suv.fuel();

        harvester.setRefuelingStation(new RefuelingStationV2());
        harvester.fuel();

        // Отправка каждого автомобиля на автомойку
        carWash.washCar(sedan);
        carWash.washCar(suv);
        carWash.washCar(harvester);

        // Вычисление стоимости обслуживания для каждого автомобиля
        double sedanMaintenanceCost = calculateMaintenance(sedan);
        double suvMaintenanceCost = calculateMaintenance(suv);
        double harvesterMaintenanceCost = calculateMaintenance(harvester);

        // Вывод стоимости обслуживания для каждого автомобиля
        System.out.println("Расходы на техническое обслуживание Седан: " + sedanMaintenanceCost);
        System.out.println("Расходы на техническое обслуживание Внедорожник: " + suvMaintenanceCost);
        System.out.println("Расходы на техническое обслуживание Уборщик: " + harvesterMaintenanceCost);
    }


    public static double calculateMaintenance(Car car) {
        if (car.getWheelsCount() == 6) {
            return 1500 * 6;
        } else {
            return 1000 * 4;
        }
    }

}

