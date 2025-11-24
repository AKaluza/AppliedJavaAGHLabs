import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UseMethodRefTests {
  String expected = "Maximum value is: 9" + System.lineSeparator();
  @Test
  public void testSolution() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    UseMethodRef.main(new String[] {""});
    Assertions.assertEquals(expected,out.toString());
  }
}