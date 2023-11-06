package HW5;

import java.util.Collection;

public interface UILayer {

    void openProject(String fileName);
    void saveProject();
    void showProjectSettings();
    void printAllModels();
    void printAllTextures();
    void renderAll();
    void renderModel(int i);
    void addModel(Model3D model);
    void removeModel(Model3D model);
    void addTexture(Texture texture);
    void removeTexture(Texture texture);

}
