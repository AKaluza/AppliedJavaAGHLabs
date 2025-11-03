import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorRefactorTest {

  @Test
  @DisplayName("There is exactly ONE feedResults method with the correct public static signature")
  void shouldHaveSingleFeedResultsWithCorrectSignature() throws Exception {
    Method[] all = Calculator.class.getDeclaredMethods();
    List<Method> feeds = Arrays.stream(all)
            .filter(m -> m.getName().equals("feedResults"))
            .toList();

    // 1) dokładnie jedna metoda feedResults
    assertEquals(1, feeds.size(), () ->
            "Expected exactly one feedResults method after refactor, found: " + feeds.size());

    Method feed = feeds.get(0);

    // 2) public static
    int mods = feed.getModifiers();
    assertTrue(Modifier.isPublic(mods), "feedResults must be public");
    assertTrue(Modifier.isStatic(mods), "feedResults must be static");

    // 3) dwa parametry: CalculationObserver<? super Integer>, int...
    Class<?>[] paramTypes = feed.getParameterTypes();
    assertEquals(2, paramTypes.length, "feedResults should have two parameters");
    assertEquals(CalculationObserver.class, paramTypes[0],
            "First parameter raw type must be CalculationObserver");
    assertEquals(int[].class, paramTypes[1],
            "Second parameter must be int... (seen as int[] via reflection)");

    // 4) weryfikacja dokładnie "? super Integer" w typie generycznym
    Type[] genericParamTypes = feed.getGenericParameterTypes();
    assertEquals(2, genericParamTypes.length);

    Type firstGeneric = genericParamTypes[0];
    assertTrue(firstGeneric instanceof ParameterizedType,
            "First parameter must be a parameterized type CalculationObserver<? super Integer>");

    ParameterizedType pType = (ParameterizedType) firstGeneric;
    assertEquals(CalculationObserver.class, pType.getRawType(),
            "Raw type must be CalculationObserver");

    Type[] typeArgs = pType.getActualTypeArguments();
    assertEquals(1, typeArgs.length, "CalculationObserver should have exactly one type argument");

    assertTrue(typeArgs[0] instanceof WildcardType,
            "Type argument must be a wildcard (? super Integer)");
    WildcardType wc = (WildcardType) typeArgs[0];

    // Lower bound should be Integer
    Type[] lowers = wc.getLowerBounds();
    assertEquals(1, lowers.length, "Expected single lower bound for ? super Integer");
    assertEquals(Integer.class, lowers[0], "Lower bound must be Integer (i.e., ? super Integer)");

    // Upper bound for wildcard defaults to Object
    Type[] uppers = wc.getUpperBounds();
    assertEquals(1, uppers.length, "Wildcard should have a single upper bound");
    assertEquals(Object.class, uppers[0], "Upper bound of wildcard should be Object");
  }

  @Test
  @DisplayName("Old overloads for specific observers do NOT exist anymore")
  void shouldNotHaveOldOverloads() throws Exception {
    // Próbujemy wyszukać stare sygnatury — jeśli istnieją, test ma wykryć.
    assertThrows(NoSuchMethodException.class,
            () -> Calculator.class.getDeclaredMethod("feedResults", IntegerObserver.class, int[].class),
            "Old overload feedResults(IntegerObserver, int...) must be removed");

    assertThrows(NoSuchMethodException.class,
            () -> Calculator.class.getDeclaredMethod("feedResults", NumberObserver.class, int[].class),
            "Old overload feedResults(NumberObserver, int...) must be removed");

    assertThrows(NoSuchMethodException.class,
            () -> Calculator.class.getDeclaredMethod("feedResults", ObjectObserver.class, int[].class),
            "Old overload feedResults(ObjectObserver, int...) must be removed");
  }

  @Test
  @DisplayName("Behavior preserved: works with IntegerObserver")
  void behaviorIntegerObserver() {
    IntegerObserver obs = new IntegerObserver();
    Calculator.feedResults(obs, 2, 3, 5);
    assertEquals(10, obs.getSum(), "Sum in IntegerObserver should be 10");
  }

  @Test
  @DisplayName("Behavior preserved: works with NumberObserver")
  void behaviorNumberObserver() {
    NumberObserver obs = new NumberObserver();
    Calculator.feedResults(obs, 2, 4, 6, 8);
    assertEquals(5.0, obs.getAverage(), 1e-9, "Average in NumberObserver should be 5.0");
  }

  @Test
  @DisplayName("Behavior preserved: works with ObjectObserver")
  void behaviorObjectObserver() {
    ObjectObserver obs = new ObjectObserver();
    Calculator.feedResults(obs, 1, 1, 1);
    assertEquals(3, obs.getObservedCount(), "ObjectObserver should count all observed values");
  }
}
