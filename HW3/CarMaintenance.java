package HW3;

public class CarMaintenance {

    private String maintenanceType; // Тип обслуживания
    private String description; // Описание
    private boolean isCompleted; // Выполнено ли обслуживание
    private double cost; // Стоимость обслуживания

    /**
     * Конструктор класса CarMaintenance
     *
     * @param maintenanceType Тип обслуживания автомобиля
     * @param description     Описание обслуживания
     * @param cost            Стоимость обслуживания
     */
    public CarMaintenance(String maintenanceType, String description, double cost) {
        this.maintenanceType = maintenanceType;
        this.description = description;
        this.isCompleted = false;
        this.cost = cost;
    }

    public String getMaintenanceType() {
        return maintenanceType;
    }

    public String getDescription() {
        return description;
    }


//      Проверить, выполнено ли обслуживание
//      @return true, если обслуживание выполнено, в противном случае - false

    public boolean isCompleted() {
        return isCompleted;
    }


//      Установить статус выполнения обслуживания
//      @param completed true, если обслуживание выполнено, в противном случае - false

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }


//     Получить стоимость обслуживания
//     @return Стоимость обслуживания

    public double getCost() {
        return cost;
    }


//     Установить стоимость обслуживания
//     @param cost Стоимость обслуживания в долларах

    public void setCost(double cost) {
        this.cost = cost;
    }


//      Выполнить обслуживание и вывести информацию

    public void performMaintenance() {
        System.out.println("Выполняется обслуживание типа: " + maintenanceType);
        System.out.println("Описание обслуживания: " + description);
        System.out.println("Стоимость обслуживания: " + cost + " руб");
        System.out.println("Обслуживание выполнено: " + isCompleted);
    }
}


