import base.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Paths;


import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BasicsIOMockitoTest extends BasicsIOBaseTest{
    private static final IFileService fileService = mock(IFileService.class);
    private static final File file = new File(fileService);
    private static final String nonExistingFileNameAbsolute = Paths.get(nonExistingFileName).toAbsolutePath().toString();
    private static final String existingFileNameAbsolute =  Paths.get(existingFileName).toAbsolutePath().toString();

    @BeforeAll
    static void setUp() {
        when(fileService.getAbsoluteName(nonExistingFileName)).thenReturn(nonExistingFileNameAbsolute);
        when(fileService.getAbsoluteName(nonExistingFileNameAbsolute)).thenReturn(nonExistingFileNameAbsolute);
        when(fileService.getAbsoluteName(existingFileName)).thenReturn(existingFileNameAbsolute);
        when(fileService.getAbsoluteName(existingFileNameAbsolute)).thenReturn(existingFileNameAbsolute);
        when(fileService.exists(existingFileNameAbsolute)).thenReturn(true);
        when(fileService.exists(nonExistingFileNameAbsolute)).thenReturn(false);
    }
    @BeforeEach
    public void BeforeTest() throws IOException {Before();}

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
        when(fileService.exists(nonExistingFileNameAbsolute)).thenReturn(false,true);

        StringBuilder result = new StringBuilder();
        boolean passed = super.checkOpenAndCreateFile(new BasicsIO(), result, false);

        Assertions.assertTrue(passed, result.toString());
    }

    @Test
    public void isDirectoryTest() {
        when(fileService.isDirectory(existingFileNameAbsolute)).thenReturn(false);
        String existingFileParent = fileService.getParentDirName(existingFileNameAbsolute);
        when(fileService.isDirectory(existingFileParent)).thenReturn(true);

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