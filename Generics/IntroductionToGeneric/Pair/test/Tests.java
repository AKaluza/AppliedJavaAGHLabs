import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Tests {

  @Test
  void shouldStoreKeyAndValue() {
    Pair<String, Integer> pair = new Pair<>("Age", 30);
    assertEquals("Age", pair.getKey());
    assertEquals(30, pair.getValue());
  }

  @Test
  void shouldConvertToReadableString() {
    Pair<String, String> pair = new Pair<>("Language", "Java");
    assertEquals("(Language = Java)", pair.toString());
  }
}