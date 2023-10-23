package HW1.store3d.modelelements;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Scene {

    //region Инициализатор и конструкторы
    private static int counter = 0;
    private final int id;
    private Collection<PoligonalModel> models;
    private Collection<Flash> flashes;
    private Collection<Camera> cameras;

    {
        id = ++counter;
    }

    public Scene(Collection<PoligonalModel> models, Collection<Flash> flashes, Collection<Camera> cameras) {
        this.models = new HashSet<>(models);
        this.flashes = new HashSet<>(flashes);
        this.cameras = new HashSet<>(cameras);
    }

    public Scene(Collection<PoligonalModel> models, Collection<Camera> cameras) {
        this(models, Collections.emptyList(), cameras);
    }
    //endregion

    //region Свойства
    public int getId() {
        return id;
    }

    public Collection<PoligonalModel> getModels() {
        return models;
    }

    public void setModels(Collection<PoligonalModel> models) {
        this.models = new HashSet<>(models);
    }

    public Collection<Flash> getFlashes() {
        return flashes;
    }

    public void setFlashes(Collection<Flash> flashes) {
        this.flashes = new HashSet<>(flashes);
    }

    public Collection<Camera> getCameras() {
        return cameras;
    }

    public void setCameras(Collection<Camera> cameras) {
        this.cameras = new HashSet<>(cameras);
    }
    //endregion
}
