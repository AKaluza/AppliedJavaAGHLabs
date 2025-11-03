import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class ArrayPrinterTest {

  @Test
  void shouldPrintIntegerArray() {
    Integer[] numbers = {1, 2, 3};
    String output = captureOutput(() -> ArrayPrinter.printArray(numbers));
    assertTrue(output.contains("1"));
    assertTrue(output.contains("2"));
    assertTrue(output.contains("3"));
  }

  @Test
  void shouldPrintStringArray() {
    String[] words = {"Java", "Generics"};
    String output = captureOutput(() -> ArrayPrinter.printArray(words));
    assertTrue(output.contains("Java"));
    assertTrue(output.contains("Generics"));
  }

  private String captureOutput(Runnable action) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream original = System.out;
    System.setOut(new PrintStream(baos));
    action.run();
    System.setOut(original);
    return baos.toString().trim();
  }
}