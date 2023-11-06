package HW5;

import java.util.Collection;

public interface BusinessLogicalLayer {

    Collection<Model3D> getAllModels();
    Collection<Texture> getAllTextures();

    // Добавить 3D модель в проект
    void addModel(Model3D model);

    // Удалить 3D модель из проекта
    void removeModel(Model3D model);

    // Добавить текстуру в проект
    void addTexture(Texture texture);

    // Удалить текстуру из проекта
    void removeTexture(Texture texture);

    void renderModel(Model3D model);
    void renderAllModels();
}

