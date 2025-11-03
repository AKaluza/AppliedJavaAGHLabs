/**
 * Observes any numeric calculation (like f: R → R).
 */
public class NumberObserver extends CalculationObserver<Number> {

    private double total = 0.0;
    private int count = 0;

    @Override
    public void observe(Number value) {
        total += value.doubleValue();
        count++;
        System.out.println("NumberObserver avg = " + (total / count));
    }

    public double getAverage() {
        return count == 0 ? 0.0 : total / count;
    }
}
