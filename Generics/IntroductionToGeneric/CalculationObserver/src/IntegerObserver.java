/**
 * Observes integer calculations (like f: Z → Z).
 */
public class IntegerObserver extends CalculationObserver<Integer> {

    private int sum = 0;

    @Override
    public void observe(Integer value) {
        sum += value;
        System.out.println("IntegerObserver sum = " + sum);
    }

    public int getSum() {
        return sum;
    }
}
