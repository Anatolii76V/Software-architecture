package HW1.store3d.inmemorymodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import HW1.store3d.modelelements.Camera;
import HW1.store3d.modelelements.Flash;
import HW1.store3d.modelelements.PoligonalModel;
import HW1.store3d.modelelements.Scene;

public class ModelStore implements ModelChanger {
    //region Публичные методы

    public void addPoligonalModel(PoligonalModel model) {
        poligonalModels.add(model);
        this.notifyChange();
    }

    public void removePolyModel(PoligonalModel model) {
        poligonalModels.remove(model);
        this.notifyChange();
    }

    public void addScene(Scene scene) {
        scenes.add(scene);
        this.notifyChange();
    }

    public void removeScene(Scene scene) {
        scenes.remove(scene);
        this.notifyChange();
    }

    public void addFlash(Flash flash) {
        flashes.add(flash);
        this.notifyChange();
    }

    public void removeFlash(Flash flash) {
        flashes.remove(flash);
        this.notifyChange();
    }

    public Scene getScene(int sceneId) {
        for (Scene scene : scenes) {
            if (scene.getId() == sceneId) {
                return scene;
            }
        }
        return null;
    }

    public void addCamera(Camera camera) {
        cameras.add(camera);
        this.notifyChange();
    }

    public void removeCamera(Camera camera) {
        cameras.remove(camera);
        this.notifyChange();
    }
    
    @Override
    public void notifyChange() {
        for (ModelChangedObserver observer : new HashSet<>(changeObservers)) {
            observer.applyUpdateModel();
        }
    }

    @Override
    public void registerModelChanger(ModelChangedObserver o) {
        changeObservers.add(o);
    }

    @Override
    public void removeModelChanger(ModelChangedObserver o) {
        changeObservers.remove(o);
    }
    //endregion

    //region Свойства

    public Collection<PoligonalModel> getPolygonalModels() {
        return new ArrayList<>(poligonalModels);
    }

    public Collection<Scene> getScenes() {
        return new ArrayList<>(scenes);
    }

    public Collection<Flash> getFlashes() {
        return new ArrayList<>(flashes);
    }

    public Collection<Camera> getCameras() {
        return new ArrayList<>(cameras);
    }

    //endregion

    //region Поля

    private final Set<PoligonalModel> poligonalModels = new HashSet<>();
    private final Set<Scene> scenes = new HashSet<>();
    private final Set<Flash> flashes = new HashSet<>();
    private final Set<Camera> cameras = new HashSet<>();
    private final List<ModelChangedObserver> changeObservers = new ArrayList<>();

    //endregion
}
