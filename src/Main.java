import static java.lang.Math.*;

public class Main {
  static final int C_LEN = 17;
  static final int X_LEN = 18;

  public static void main(String[] args) {
    short[] c = new short[C_LEN];
    for (int i = 0; i < C_LEN; i++) {
      c[i] = (short) (C_LEN - i);
    }

    double[] x = new double[X_LEN];
    for (int i = 0; i < X_LEN; i++) {
      x[i] = randomDouble(-5d, 15d);
    }

    double[][] s = new double[C_LEN][X_LEN];
    for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < s[i].length; j++) {
        var y = x[j];
        s[i][j] = switch (c[i]) {
          case 4 -> f1(y);
          case 5, 7, 8, 10, 12, 13, 14, 16 -> f2(y);
          default -> f3(y);
        };
        System.out.printf("%-10.5f", s[i][j]);
      }
      System.out.println();
    }
  }

  private static double f1(double x) {
    return pow(sin((x + 0.5) / 2), 0.5 / ((x * (x + 0.5) + 1) * 2));
  }

  private static double f2(double x) {
    return log(pow(pow(tan(x), 2), 2));
  }

  private static double f3(double x) {
    return Math
        .sin(pow(0.75 * (pow((3 - cbrt(x)) / asin((x + 5) / 2 * E + 1), 3) + PI),
            atan(1 / (pow(E, abs(x))))));
  }

  /**
   * Returns random double [a ; b)
   * 
   * @param a lower bound (inclusive)
   * @param b upper bound (non-inclusive)
   */
  private static double randomDouble(double a, double b) {
    return random() * (b - a) + a;
  }
}
