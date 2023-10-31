package HW3;

import java.awt.*;

import HW3.Refueling;

public abstract class Car {

    private Refueling refueling;
    private String registrationNumber;
    private boolean isEngineOn;
    private boolean carWashNeeded = false;
    private String make;
    private String model;
    private Color color;
    private GearboxType gearboxType;
    private double engineCapacity;


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void turnOnEngine() {
        isEngineOn = true;
    }

    public void turnOffEngine() {
        isEngineOn = false;
    }

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    // Доработка конструктора
    public Car(String make, String model, Color color, CarType type, GearboxType gearboxType, double engineCapacity) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.type = type;
        this.gearboxType = gearboxType;
        this.engineCapacity = engineCapacity;

    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null && !registrationNumber.isEmpty()) {
            this.registrationNumber = registrationNumber;
        } else {
            System.out.println("Ошибка: Номер регистрации не может быть пустым.");
        }
    }

    /**
     * Заправить автомобиль
     */
    public void fuel() {
        if (refueling != null) {
            boolean isRefueled = refueling.fuel(fuelType);
            if (isRefueled) {
                System.out.println("Автомобиль успешно заправлен.");
            } else {
                System.out.println("Ошибка: Не удалось заправить автомобиль.");
            }
        } else {
            System.out.println("Ошибка: Станция заправки не определена.");
        }
    }

    //    Помыть машину

    public void setCarWashNeeded(boolean carWashNeeded) {
        this.carWashNeeded = carWashNeeded;
    }

    public boolean isCarWashNeeded() {
        return carWashNeeded;
    }


    protected void setWheelsCount(int wheelsCount) {
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

    // Движение
    public abstract void movement();

    // Обслуживание
    public abstract void maintenance();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadlights();

    // Включение дворников
    public abstract boolean switchWipers();

    //region Конструкторы

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }


    //endregion

    //region Поля


    // Тип
    protected CarType type;

    // Число колес
    private int wheelsCount;

    // Тип топлива
    protected FuelType fuelType = FuelType.Diesel;


    // Состояние противотуманных фар
    private boolean fogLights = false;

    //endregion


}