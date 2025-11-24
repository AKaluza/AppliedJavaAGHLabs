
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class GenericMethodRefTests {
  String expected = "vals contains 3 4s" + System.lineSeparator() + "strs contains 2 Twos"+ System.lineSeparator();
  @Test
  public void testSolution() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    GenericMethodRefDemo.main(new String[] {""});
    Assertions.assertEquals(expected, out.toString());
  }


}