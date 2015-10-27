package ua.dobro;

public class OSystem {
    private FileManager fileManager;
    private LaptopBrandnew laptop;

    public OSystem(LaptopBrandnew laptop) throws LaptopAccessException {
        if (!laptop.isLaptopState()) {
            throw new LaptopAccessException();
        }
        this.laptop = laptop;
    }

    /**
     * @return the fileManager
     */
    public FileManager getFileManager() {
        return fileManager;
    }

    /**
     * @param fileManager
     *            the fileManager to set
     */
    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

}
