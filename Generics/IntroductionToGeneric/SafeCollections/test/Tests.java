import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoxTest {

  @Test
  void shouldStoreAndReturnInteger() {
    Box<Integer> intBox = new Box<>();
    intBox.set(100);
    assertEquals(100, intBox.get());
  }

  @Test
  void shouldStoreAndReturnString() {
    Box<String> strBox = new Box<>();
    strBox.set("Java");
    assertEquals("Java", strBox.get());
  }

  @Test
  void shouldReportEmptyWhenNoValueSet() {
    Box<Double> box = new Box<>();
    assertTrue(box.isEmpty());
  }
}