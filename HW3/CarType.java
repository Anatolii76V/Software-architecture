package HW3;

public enum CarType {
    Sedan("Седан", "Седан - легковой автомобиль с тремя отсеками для двигателя, пассажиров и груза."),
    Hatchback("Хэтчбек", "Хэтчбек - автомобиль с задней дверью, открывающейся вверх."),
    Pickup("Пикап", "Пикап - легкий грузовик с закрытой кабиной и открытой грузовой площадкой " +
            "с низкими бортами и задней стенкой."),
    Sport("Спорткар", "Спорткар - автомобиль, разработанный для спортивного вождения."),
    SUV("Внедорожник", "Внедорожник - прочное автомобильное средство, " +
            "предназначенное для движения как по дорогам, так и вне их."),
    Convertible("Кабриолет", "Кабриолет - автомобиль с откидным или съемным верхом."),
    Harvester("Комбайн", "Комбайн - машина для уборки.");

    private final String typeName;
    private final String description;

    CarType(String typeName, String description) {
        this.typeName = typeName;
        this.description = description;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getDescription() {
        return description;
    }
}
