/**
 * Observes all types of results (like f: U → U).
 */
public class ObjectObserver extends CalculationObserver<Object> {

    private int observedCount = 0;

    @Override
    public void observe(Object value) {
        observedCount++;
        System.out.println("ObjectObserver saw: " + value.getClass().getSimpleName());
    }

    public int getObservedCount() {
        return observedCount;
    }
}
