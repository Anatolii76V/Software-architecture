package HW3;

import java.awt.*;

public class Sedan extends Car {

    private boolean hasSunroof;

    public Sedan(String brand, String model, Color color, CarType type, GearboxType gearboxType, double engineVolume, boolean hasSunroof) {
        super(brand, model, color, type, gearboxType, engineVolume);
        this.hasSunroof = hasSunroof;
    }

    @Override
    public void movement() {
        // Реализация движения для седана
    }

    @Override
    public void maintenance() {
        // Реализация обслуживания для седана
    }

    @Override
    public boolean gearShifting() {
        // Реализация переключения передач для седана
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        // Реализация включения фар для седана
        return false;
    }

    @Override
    public boolean switchWipers() {
        // Реализация включения дворников для седана
        return false;
    }
}
