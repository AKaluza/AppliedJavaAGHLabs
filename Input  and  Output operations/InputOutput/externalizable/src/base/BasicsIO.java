package base;

import java.io.File;
import java.io.IOException;

public class BasicsIO implements IBasicsIO {
    @Override
    public File openFile(String path) {
        return new File(path);
    }

    @Override
    public File openAndCreateFile(String path) throws IOException {
        File file = openFile(path);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
        return file;
    }

    @Override
    public boolean isDirectory(File file) {
        return file.isDirectory();
    }

    @Override
    public String getAbsolutePath(File file) {
        return file.getAbsolutePath();
    }

    @Override
    public String getName(File file) {
        return file.getName();
    }
}
