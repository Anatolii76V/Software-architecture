package HW1.store3d.inmemorymodel;

// Класс CustomService3 реализует интерфейс ModelChangedObserver
public class CustomService3 implements ModelChangedObserver {

    // Переопределенный метод для реагирования на изменения в хранилище моделей
    @Override
    public void applyUpdateModel() {
        System.out.println("Реагирует на изменение в хранилище моделей");
    }
}



