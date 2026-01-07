import base.File;
import org.junit.jupiter.api.BeforeEach;


import java.io.IOException;

public class BasicsIOTestsBase {
    protected static String existingFileName= "data/directoryToBeCreated/anotherDir/file";
    protected static String nonExistingFileName= "data/directoryToBeCreated/anotherDir/nonExistingFile";
    protected File existingFile;
    protected File nonExistingFile;
    private final String existingPath1 = "directoryToBeCreated/";
    private final String existingPath2 = "anotherDir/";
    private final String existingPath3 = "file";
    private final String nonExistingPath1 = "nonExistingDirectory/";
    private final String nonExistingPath2 = "anotherDir/";
    private final String nonExistingPath3 = "nonExistingFile";

    public BasicsIOTestsBase() {
    }

    @BeforeEach
    public void Before() throws IOException {
        this.existingFile = new File(existingFileName);
        delete(this.existingFile);
        if (!this.existingFile.exists()) {
            this.existingFile.getParentFile().mkdirs();
            this.existingFile.createNewFile();
        }

        this.nonExistingFile = new File(nonExistingFileName);
        delete(this.nonExistingFile);
    }

    protected static void delete(File toDelete) throws IOException {
        if (toDelete.exists()) {
            if (toDelete.isDirectory()) {
                File[] list = toDelete.listFiles();
                File[] var5 = list;
                int var4 = list.length;

                for(int var3 = 0; var3 < var4; ++var3) {
                    File file = var5[var3];
                    delete(file);
                }
            }

            toDelete.delete();
        }

    }

    protected boolean checkOpenFileWithExistingFile(IBasicsIO toTest, StringBuilder result) {
        File output = toTest.openFile(this.existingFile.getAbsolutePath());
        if (output == null) {
            result.append("We have recived null object");
            return false;
        } else if (output.exists() && output.getAbsolutePath().equals(this.existingFile.getAbsolutePath())) {
            return true;
        } else {
            result.append("Check if you have open correct file, it should return: \"").append(this.existingFile.getAbsolutePath()).append("\", but we got: \"").append(output.getAbsolutePath()).append("\"");
            return false;
        }
    }

    protected boolean checkOpenAndCreateFile(IBasicsIO toTest, StringBuilder result, boolean useExistingFile) {
        File tester = useExistingFile ? this.existingFile : this.nonExistingFile;

        File output;
        try {
            output = toTest.openAndCreateFile(tester.getAbsolutePath());
        } catch (IOException var7) {
            result.append("We got exeption: ").append(var7.getMessage());
            return false;
        }

        if (output == null) {
            result.append("We have recived null object");
            return false;
        } else if (!output.getAbsolutePath().equals(tester.getAbsolutePath())) {
            result.append("Check if you have open correct file, it should return: \"").append(tester.getAbsolutePath()).append("\", but we got: \"").append(output.getAbsolutePath()).append("\"");
            return false;
        } else if (!output.exists()) {
            result.append("File don't exist, create it first (and all its directories)");
            return false;
        } else if (output.isDirectory()) {
            result.append("File is directory - remeber, you should use mkdirs mehtod just for parent file!");
            return false;
        } else {
            return true;
        }
    }

    protected boolean checkOpenFileWithNonExistingFile(IBasicsIO toTest, StringBuilder result) {
        File output = toTest.openFile(this.nonExistingFile.getAbsolutePath());
        if (output == null) {
            result.append("We have recived null object");
            return false;
        } else if (!output.getAbsolutePath().equals(this.nonExistingFile.getAbsolutePath())) {
            result.append("Check if you have open correct file, it should return: \"").append(this.nonExistingFile.getAbsolutePath()).append("\", but we got: \"").append(output.getAbsolutePath()).append("\"");
            return false;
        } else if (output.exists()) {
            result.append("File exists, you shouldn't create that file!");
            return false;
        } else {
            return true;
        }
    }

    protected boolean isDirectory(IBasicsIO toTest, StringBuilder result) {
        if (toTest.isDirectory(this.existingFile)) {
            result.append(this.existingFile.getAbsolutePath()).append(" <- it is not directory but methods returns true!");
            return false;
        } else if (!toTest.isDirectory(this.existingFile.getParentFile())) {
            result.append(this.existingFile.getParentFile().getAbsolutePath()).append(" <- it is directory but methods returns false!");
            return false;
        } else {
            return true;
        }
    }
}