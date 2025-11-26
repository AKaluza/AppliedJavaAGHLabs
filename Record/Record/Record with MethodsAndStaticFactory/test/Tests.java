import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

  @Test
  void shouldCreateProductAndApplyDiscount() {
    ProductMy p = new ProductMy("Monitor", 1000.0);
    ProductMy discounted = p.withDiscount(10.0);

    assertEquals("Monitor", discounted.name());
    assertEquals(900.0, discounted.price(), 0.001);
    assertNotSame(p, discounted, "Record should be immutable — return new instance");
  }

  @Test
  void shouldRejectInvalidPrice() {
    assertThrows(IllegalArgumentException.class,
            () -> new ProductMy("Mouse", -5.0));
  }

  @Test
  void shouldCreateUsingFactoryMethod() {
    ProductMy mouse = ProductMy.of("Mouse", 129.99);
    assertEquals("Mouse", mouse.name());
    assertEquals(129.99, mouse.price());
  }

  @Test
  void shouldKeepToStringReadable() {
    ProductMy p = new ProductMy("Keyboard", 199.0);
    assertTrue(p.toString().contains("Keyboard"));
    assertTrue(p.toString().contains("price"));
  }
}
