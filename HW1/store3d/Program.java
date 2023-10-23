package HW1.store3d;

import HW1.store3d.inmemorymodel.*;
import HW1.store3d.modelelements.*;

import java.awt.*;

public class Program {

    public static void main(String[] args) {

        ModelChangedObserver observer1 = new CustomService1();
        ModelChangedObserver observer2 = new CustomService2();
        ModelChangedObserver observer3 = new CustomService3();

        ModelStore modelStore = new ModelStore();
        modelStore.registerModelChanger(observer1);
        modelStore.registerModelChanger(observer2);
        modelStore.registerModelChanger(observer3);

        Point3D point1 = new Point3D(1, 2, 3);
        Point3D point2 = new Point3D(4, 5, 6);
        Angle3D angle1 = new Angle3D(45, 30, 60);
        Angle3D angle2 = new Angle3D(60, 45, 30);
        Color color1 = new Color(255, 255, 255);
        Color color2 = new Color(0, 0, 0);

        Flash flash1 = new Flash(point1, angle1, color1, 10.5);
        Flash flash2 = new Flash(point2, angle2, color2, 8.0);

        modelStore.addFlash(flash1);
        modelStore.addFlash(flash2);
        
    }
}
