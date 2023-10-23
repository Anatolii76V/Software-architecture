package HW1.store3d.modelelements;

public class Angle3D {
    private double xAngle;
    private double yAngle;
    private double zAngle;

    // Конструктор
    public Angle3D(double xAngle, double yAngle, double zAngle) {
        this.xAngle = xAngle;
        this.yAngle = yAngle;
        this.zAngle = zAngle;
    }

    // Получение суммарного угла
    public double getTotalAngle() {
        return xAngle + yAngle + zAngle;
    }

    // Поворот угла по осям
    public void rotateByX(double angle) {
        this.xAngle += angle;
    }

    public void rotateByY(double angle) {
        this.yAngle += angle;
    }

    public void rotateByZ(double angle) {
        this.zAngle += angle;
    }

    // Получение углов
    public double getXAngle() {
        return xAngle;
    }

    public double getYAngle() {
        return yAngle;
    }

    public double getZAngle() {
        return zAngle;
    }
}
