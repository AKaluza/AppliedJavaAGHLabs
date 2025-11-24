/**
 * Demonstrates ? super Integer in a numerical, hierarchical context.
 */
public class Calculator {

    /**
     * Feeds integer results into a more general observer.
     * The observer can accept Integer, Number, or Object values.
     */

    public static void feedResults(CalculationObserver<? super Integer> observer, int... values) {
        for (int v : values) {
            observer.observe(v);
        }
    } 
}
