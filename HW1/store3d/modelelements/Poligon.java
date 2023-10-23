package HW1.store3d.modelelements;

import java.util.Collection;


public class Poligon {

    private Collection<Point3D> points;

    public Collection<Point3D> getPoints() {
        return points;
    }

    public Poligon(Collection<Point3D> points) {
        this.points = points;
    }

    public Poligon() {
    }

}
