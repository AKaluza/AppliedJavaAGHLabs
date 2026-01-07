import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

public class JacksonJsonGeneratorTests {
  @Test
  public void testSolution() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    JacksonJsonGenerator.writeAsJSON(out);
    String expected = "[{\"brand\":\"Mercedes\",\"doors\":5},{\"brand\":\"Fiat\",\"doors\":4},{\"brand\":\"Opel\",\"doors\":3}]";
    Assertions.assertEquals(expected,out.toString());
  }
}