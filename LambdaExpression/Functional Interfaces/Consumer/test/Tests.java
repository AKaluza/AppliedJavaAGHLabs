import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;


public class Tests {
  @Test
  void consumerPrintsUppercase() {
    Task t = new Task();
    Consumer<String> t_s = t.getShout();
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream orig = System.out;
    System.setOut(new PrintStream(baos));

    try {
      t_s.accept("hello");
    } finally {
      System.setOut(orig);
    }

    assertTrue(baos.toString().trim().equals("HELLO!"));
  }
}