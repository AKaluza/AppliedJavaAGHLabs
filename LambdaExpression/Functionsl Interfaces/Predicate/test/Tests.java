import org.junit.jupiter.api.Test;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
  @Test
  void predicateChecksCapital() {
    Task t = new Task();

    assertTrue(t.startsWithCapitalAndNonEmpty.test("Bob"));
    assertTrue(t.startsWithCapitalAndNonEmpty.test("  Carol"));
    assertFalse(t.startsWithCapitalAndNonEmpty.test("alice"));
    assertFalse(t.startsWithCapitalAndNonEmpty.test(" "));
    assertFalse(t.startsWithCapitalAndNonEmpty.test(null));
  }
}