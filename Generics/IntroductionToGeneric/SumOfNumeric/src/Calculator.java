public class Calculator {

    // TODO: Implement a generic method that sums two numbers of any numeric type.
    // Use an upper bound in a correct form
    // Return the result as double.
    public static <T extends Number> double add(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }
}