import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

  @Test
  void shouldTrackCreatedProducts() {
    int before = Product.getCreatedCount();

    new Product("Monitor", 999.0);
    new Product("Headphones", 399.0);

    assertTrue(Product.getCreatedCount() >= before + 2,
            "Static counter should increase after creating new instances");
  }

  @Test
  void defaultProductShouldExist() {
    Product def = Product.DEFAULT;
    assertEquals("Unknown", def.name());
    assertEquals(0.0, def.price());
  }

  @Test
  void staticFieldsShouldBeAccessibleViaType() {
    Product p = new Product("Microphone", 299.0);
    assertNotNull(Product.DEFAULT);
    assertEquals(p.getClass(), Product.DEFAULT.getClass());
  }
}