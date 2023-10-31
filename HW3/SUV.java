package HW3;

import java.awt.*;

public class SUV extends Car {

    private boolean isFourWheelDrive;

    public SUV(String make, String model, Color color, CarType type, GearboxType gearboxType, double engineCapacity, boolean isFourWheelDrive) {
        super(make, model, color, type, gearboxType, engineCapacity);
        this.isFourWheelDrive = isFourWheelDrive;
    }

    @Override
    public void movement() {
        // Реализация движения для внедорожника
    }

    @Override
    public void maintenance() {
        // Реализация обслуживания для внедорожника
    }

    @Override
    public boolean gearShifting() {
        // Реализация переключения передач для внедорожника
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        // Реализация включения фар для внедорожника
        return false;
    }

    @Override
    public boolean switchWipers() {
        // Реализация включения дворников для внедорожника
        return false;
    }
}
