import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;

import java.io.*;

public class BRReadTests {
  @Test
  //@DisplayName("Add two numbers")
  public void testSolution() throws IOException {
    String data = "awsedefgq";
    ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes() );
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setIn(in);
    System.setOut(new PrintStream(out));
    BRRead.main(new String[]{""});
    Assertions.assertEquals("Enter characters, 'q' to quit." + System.lineSeparator() + data, out.toString());

  }
}