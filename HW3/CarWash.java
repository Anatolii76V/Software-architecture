package HW3;

/**
 * Класс CarWash представляет собой автомойку с разными ценами в зависимости от типа автомобиля.
 */
public class CarWash {

    private double sedanWashPrice; // Цена мойки седана
    private double suvWashPrice; // Цена мойки внедорожника

    /**
     * Конструктор класса CarWash для инициализации цен на мойку.
     *
     * @param sedanWashPrice Цена мойки седана в рублях
     * @param suvWashPrice   Цена мойки внедорожника в рублях
     */
    public CarWash(double sedanWashPrice, double suvWashPrice) {
        this.sedanWashPrice = sedanWashPrice;
        this.suvWashPrice = suvWashPrice;
    }


//      Получить цену мойки для седана.
//      @return Цена мойки седана в рублях

    public double getSedanWashPrice() {
        return sedanWashPrice;
    }


//      Установить цену мойки для седана.
//      @param sedanWashPrice Цена мойки седана в рублях

    public void setSedanWashPrice(double sedanWashPrice) {
        this.sedanWashPrice = sedanWashPrice;
    }


//      Получить цену мойки для внедорожника.
//      @return Цена мойки внедорожника в рублях

    public double getSuvWashPrice() {
        return suvWashPrice;
    }


//      Установить цену мойки для внедорожника.
//      @param suvWashPrice Цена мойки внедорожника в руб

    public void setSuvWashPrice(double suvWashPrice) {
        this.suvWashPrice = suvWashPrice;
    }


//      Выполнить мойку автомобиля и вывести информацию о цене.
//      @param car Тип автомобиля для мойки

    public void washCar(Car car) {
        if (car instanceof Sedan) {
            System.out.println("Выполняется мойку седана по цене: " + sedanWashPrice + " руб.");
        } else if (car instanceof SUV) {
            System.out.println("Выполняется мойку внедорожника по цене: " + suvWashPrice + " руб.");
        } else {
            System.out.println("Тип автомобиля не определен. Невозможно вымыть.");
        }
    }

    public void setPriceForCarType(CarType carType, double price) {
        if (carType == CarType.Sedan) {
            setSedanWashPrice(price);
        } else if (carType == CarType.SUV) {
            setSuvWashPrice(price);
        } else {
            System.out.println("Не удалось установить цену для указанного типа автомобиля.");
        }
    }

}

