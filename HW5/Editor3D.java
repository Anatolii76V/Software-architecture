package HW5;

import java.util.ArrayList;

public class Editor3D implements UILayer{

    private ProjectFile projectFile;
    private BusinessLogicalLayer businessLogicalLayer;
    private DatabaseAccess databaseAccess;
    private Database database;

    /**
     * Полностью пересобираем внутренние компоненты системы (новый проект)
     */
    private void initialize(){
        database = new EditorDatabase(projectFile);
        databaseAccess = new EditorDatabaseAccess(database);
        businessLogicalLayer = new EditorBusinessLogicalLayer(databaseAccess);
    }

    @Override
    public void openProject(String fileName) {
        projectFile = new ProjectFile(fileName);
        initialize();
    }

    @Override
    public void saveProject() {
        System.out.println("Изменения успешно сохранены.");
        database.save();
    }

    @Override
    public void showProjectSettings() {
        if (projectFile != null) {
            System.out.println("*** Настройки проекта ***");
            System.out.println("Имя файла: " + projectFile.getFileName());
            System.out.println("Настройка 1: " + projectFile.getSetting1());
            System.out.println("Настройка 2: " + projectFile.getSetting2());
            System.out.println("Настройка 3: " + projectFile.getSetting3());
        } else {
            throw new RuntimeException("Файл проекта не определен.");
        }
    }

    @Override
    public void printAllModels() {
        checkProjectFile();

        ArrayList<Model3D> models = new ArrayList<>(businessLogicalLayer.getAllModels());
        for (int i = 0; i < models.size(); i++){
            System.out.printf("===%d===\n", i);
            System.out.println(models.get(i));
            for (Texture texture: models.get(i).getTextures()) {
                System.out.printf("\t%s\n", texture);
            }
        }
    }

    @Override
    public void printAllTextures() {
        checkProjectFile();

        ArrayList<Texture> textures = new ArrayList<>(businessLogicalLayer.getAllTextures());
        for (int i = 0; i < textures.size(); i++){
            System.out.printf("===%d===\n", i);
            System.out.println(textures.get(i));
        }
    }

    @Override
    public void renderAll() {
        checkProjectFile();

        System.out.println("Пожалуйста, подождите...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderAllModels();
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция завершена за %d ms.\n", endTime);
    }

    @Override
    public void renderModel(int i) {
        checkProjectFile();

        ArrayList<Model3D> models = new ArrayList<>(businessLogicalLayer.getAllModels());
        if (i < 0 || i > models.size() - 1)
            throw new RuntimeException("Указан неверный номер модели.");
        System.out.println("Пожалуйста, подождите...");
        long startTime = System.currentTimeMillis();
        businessLogicalLayer.renderModel(models.get(i));
        long endTime = (System.currentTimeMillis() - startTime);
        System.out.printf("Операция завершена за %d ms.\n", endTime);
    }

    @Override
    public void addModel(Model3D model) {
        checkProjectFile();

        businessLogicalLayer.addModel(model);
    }

    @Override
    public void removeModel(Model3D model) {
        checkProjectFile();

        businessLogicalLayer.removeModel(model);
    }

    @Override
    public void addTexture(Texture texture) {
        checkProjectFile();

        businessLogicalLayer.addTexture(texture);
    }

    @Override
    public void removeTexture(Texture texture) {
        checkProjectFile();

        businessLogicalLayer.removeTexture(texture);
    }

    private void checkProjectFile(){
        if (projectFile == null)
            throw new RuntimeException("Файл проекта не определен.");
    }

}
