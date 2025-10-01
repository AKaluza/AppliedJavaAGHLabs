import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Tests {
  @Test
  @DisplayName("Approximated pi should converge to real pi")
  public void resultPiIsNearRealPi() {
    double expected = Math.PI;

    // (weak) convergence rate is 1/sqrt(n)
    int numberOfTries = 1000;
    double actual = 0.0;
    for (int i = 0; i < numberOfTries; i++) {
      actual = actual + Task.ApproximationOfPi(10000);
    }
    actual = actual / numberOfTries;

    Assertions.assertTrue(Math.abs(expected - actual) < 0.01, "Result deviates from Pi more then 0.01");
  }
}