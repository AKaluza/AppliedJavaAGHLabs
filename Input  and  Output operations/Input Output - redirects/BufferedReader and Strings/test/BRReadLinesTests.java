import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class BRReadLinesTests{
  String info = "Enter lines of text."+ System.lineSeparator() + "Enter 'stop' to quit."+ System.lineSeparator();
  String in_data = "Kwoka"+ System.lineSeparator() +
          ""+ System.lineSeparator() +
          "Proszę pana, pewna kwoka"+ System.lineSeparator() +
          "Traktowała świat z wysoka"+ System.lineSeparator() +
          "I mówiła z przekonaniem:"+ System.lineSeparator() +
          "\"Grunt to dobre wychowanie!\""+ System.lineSeparator() +
          "stop"+ System.lineSeparator();
  String out_data = "Enter lines of text."+ System.lineSeparator() +
          "Enter 'stop' to quit."+ System.lineSeparator() +
          in_data;
  @Test
  public void testSolution() throws IOException {
    ByteArrayInputStream in = new ByteArrayInputStream((in_data).getBytes());
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));
    System.setIn(in);
    BRReadLines.main(new String[] {""});
    Assertions.assertEquals(out_data,out.toString());
  }
}