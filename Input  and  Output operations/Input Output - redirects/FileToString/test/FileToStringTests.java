import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileToStringTests {
  String byReadString(Path file) throws IOException {
    return Files.readString(file, Charset.defaultCharset()); // java 11
  }
  @Test
  public void testSolution() throws IOException {
    // put your test here
    Path file = Paths.get("src/FileToString.java");
    String expected = byReadString(file);
    Assertions.assertEquals(expected, FileToString.byReadString(file));
    Assertions.assertEquals(expected, FileToString.byReadAllBytes(file));
    Assertions.assertEquals(expected,FileToString.byReadAllLines(file));
  }
}