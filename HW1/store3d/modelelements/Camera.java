package HW1.store3d.modelelements;

public class Camera {
    private Point3D location;
    private Angle3D angle;

    // Конструктор
    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    // Методы
    public void rotate(Angle3D newAngle) {
        this.angle = newAngle;
    }

    public void move(Point3D newLocation) {
        this.location = newLocation;
    }

    public void moveTo(double x, double y, double z) {
        this.location = new Point3D(x, y, z);
    }

    public void rotateBy(double xAngle, double yAngle, double zAngle) {
        this.angle.rotateByX(xAngle);
        this.angle.rotateByY(yAngle);
        this.angle.rotateByZ(zAngle);
    }

    public Point3D getLocation() {
        return location;
    }

    public void setLocation(Point3D location) {
        this.location = location;
    }

    public Angle3D getAngle() {
        return angle;
    }

    public void setAngle(Angle3D angle) {
        this.angle = angle;
    }
}
