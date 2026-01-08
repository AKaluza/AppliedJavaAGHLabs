import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class CopyTests {
  private static final String fileNameIn = "src/CopyFile.java";
  private static final String fileNameOut = "data/out.txt";
  @Test
  public void copyTest() throws IOException {
    Path pathIn = Paths.get(fileNameIn);
    Path pathOut = Paths.get(fileNameOut);
    Files.deleteIfExists(pathOut);
    CopyFile.copy(fileNameIn,fileNameOut);
    String expected = Files.readString(pathIn);
    Files.createDirectories(pathOut.getParent());
    String actual = Files.readString(pathOut) ;
    Assertions.assertEquals(expected,actual);
  }
}