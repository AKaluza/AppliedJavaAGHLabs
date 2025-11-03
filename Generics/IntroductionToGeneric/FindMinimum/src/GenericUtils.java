public class GenericUtils {
    public static <T extends Comparable<T>> T min(T a, T b) {
        return (a.compareTo(b) < 0) ? a : b;
    }
}