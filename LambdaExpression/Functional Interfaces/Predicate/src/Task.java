import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task {
    /* TODO: Predicate<String> startsWithCapitalAndNonEmpty = ... */
    Predicate<String> startsWithCapitalAndNonEmpty = s -> s != null && !s.trim().isEmpty() && Character.isUpperCase(s.trim().charAt(0));

    public static void main(String[] args) {


        // Uncomment after implementing:
        Task t1 = new Task();
        System.out.println(t1.startsWithCapitalAndNonEmpty.test("Alice")); // true
        System.out.println(t1.startsWithCapitalAndNonEmpty.test("alice")); // false
        System.out.println(t1.startsWithCapitalAndNonEmpty.test("   "));   // false
        System.out.println(t1.startsWithCapitalAndNonEmpty.test("   Alice"));   // true
    }
}