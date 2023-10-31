package HW3;

public class RefuelingStation implements Refueling {

    public void processfuel(FuelType fuelType) {
        switch (fuelType) {
            case Diesel -> System.out.println("Заправка дизельным топливом");
            case Gasoline -> System.out.println("Заправка бензином");
        }
    }

    @Override
    public boolean fuel(FuelType fuelType) {
        processfuel(fuelType);
        return false;
    }
}