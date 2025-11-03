import org.junit.jupiter.api.Test;
import org.opentest4j.MultipleFailuresError;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddrTests {
  AdressTest test = new AdressTest();

  @Test
  public void testSolution() {
    assertThrows(MultipleFailuresError.class, () -> test.groupedAssertions());
  }
}