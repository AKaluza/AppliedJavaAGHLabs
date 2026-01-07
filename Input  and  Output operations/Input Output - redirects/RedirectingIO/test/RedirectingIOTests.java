import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



public class RedirectingIOTests {
  @Test
  public void testSolution() throws IOException {
      String fin = "src/Redirecting.java";
      String fout = "data/test.txt";
      Path file = Paths.get(fout);
      Files.deleteIfExists(file);
      Files.createFile(file);
      Redirecting.redirectFromTo(fin,fout);
      byte[] b1 = Files.readAllBytes(file);
      String s1 = new String(b1, Charset.defaultCharset()); //Java 7
      String s2 = Files.readString(file,Charset.defaultCharset()); //Java 11
      Assertions.assertEquals(s1, s2);
  }
}