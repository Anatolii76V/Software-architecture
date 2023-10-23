package HW1.store3d.modelelements;

import java.awt.*;

public class Flash {
    // Поля класса
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private double power;

    // Конструкторы
    public Flash(Point3D location, Angle3D angle, Color color, double power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public Flash(Point3D location, Angle3D angle, double power) {
        this(location, angle, null, power);
    }

    // Методы
    public void rotate(Angle3D newAngle) {
        this.angle = newAngle;
    }

    public void move(Point3D newLocation) {
        this.location = newLocation;
    }

    // Свойства
    public Point3D getLocation() {
        return location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }
}

