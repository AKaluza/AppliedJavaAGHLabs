import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Tests {

  @Test
  void shouldCreateRecordAndCompare() {
    Book b1 = new Book("Effective Java", "Joshua Bloch");
    Book b2 = new Book("Effective Java", "Joshua Bloch");
    Book b3 = new Book("Clean Code", "Robert C. Martin");

    assertEquals(b1, b2);
    assertNotEquals(b1, b3);
  }

  @Test
  void shouldGenerateToStringAutomatically() {
    Book book = new Book("Effective Java", "Joshua Bloch");
    assertTrue(book.toString().contains("Effective Java"));
    assertTrue(book.toString().contains("Joshua Bloch"));
  }
}