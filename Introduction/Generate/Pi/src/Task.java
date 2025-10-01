import java.util.Random;

public class Task {
    public static double ApproximationOfPi(int n) {
        Random generator = new Random();

        double x, y;
        int k = 0;

        for (int i = 1; i <= n; i++) {
            x = generator.nextDouble();
            y = generator.nextDouble();
            if (x * x + y * y <= 1) {
                k++;
            }
        }
        double pi = 4. * k / n;
        return pi;
    }
}