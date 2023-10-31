package HW3;

public class RefuelingStationV2 implements Refueling {

    public void processCarFuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");
        }
    }

    @Override
    public boolean fuel(FuelType fuelType) {
        processCarFuel(fuelType);
        return false;
    }

}
