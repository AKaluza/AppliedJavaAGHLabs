import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicIOTests extends BasicsIOTestsBase {
    @Test
    public void checkOpenFileWithExistingFileTest() {
        StringBuilder result = new StringBuilder();
        boolean passed = super.checkOpenFileWithExistingFile(new BasicsIO(), result);

        Assertions.assertTrue(passed, result.toString());
    }

    @Test
    public void checkOpenFileWithNonExistingFileTest() {
        StringBuilder result = new StringBuilder();
        boolean passed = super.checkOpenFileWithNonExistingFile(new BasicsIO(), result);

        Assertions.assertTrue(passed, result.toString());
    }

    @Test
    public void checkOpenAndCreateFileWithExistingFileTest() {
        StringBuilder result = new StringBuilder();
        boolean passed = super.checkOpenAndCreateFile(new BasicsIO(), result, true);

        Assertions.assertTrue(passed, result.toString());
    }

    @Test
    public void checkOpenAndCreateFileWithNonExistingFileTest() {
        StringBuilder result = new StringBuilder();
        boolean passed = super.checkOpenAndCreateFile(new BasicsIO(), result, false);

        Assertions.assertTrue(passed, result.toString());
    }

    @Test
    public void isDirectoryTest() {
        StringBuilder result = new StringBuilder();
        boolean passed = super.isDirectory(new BasicsIO(), result);

        Assertions.assertTrue(passed, result.toString());
    }

    @Test
    public void getAbsolutePathTest() {
        Assertions.assertEquals(existingFile.getAbsolutePath(), new BasicsIO().getAbsolutePath(existingFile));
    }

    @Test
    public void getNameTest() {
        Assertions.assertEquals(existingFile.getName(), new BasicsIO().getName(existingFile));
    }


}