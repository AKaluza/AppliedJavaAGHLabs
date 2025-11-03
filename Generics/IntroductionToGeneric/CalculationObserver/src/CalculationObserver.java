/**
 * Represents something that can "observe" a numeric calculation.
 * @param <T> type of value it can observe
 */
public class CalculationObserver<T> {
    public void observe(T value) {
        System.out.println("Observed: " + value);
    }
}