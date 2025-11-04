import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

  @Test
  void shouldCreateProductRecord() {
    Product p = new Product("Laptop", 3499.0);
    assertEquals("Laptop", p.name());
    assertEquals(3499.0, p.price());
    assertTrue(p.toString().contains("Laptop"));
  }

  @Test
  void shouldRejectNegativePrice() {
    Exception ex = assertThrows(IllegalArgumentException.class,
            () -> new Product("Phone", -5.0));
    assertTrue(ex.getMessage().toLowerCase().contains("price"));
  }

  @Test
  void equalsShouldCompareByValue() {
    Product p1 = new Product("Tablet", 1200.0);
    Product p2 = new Product("Tablet", 1200.0);
    assertEquals(p1, p2);
    assertEquals(p1.hashCode(), p2.hashCode());
  }
}