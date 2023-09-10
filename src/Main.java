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
        if (c[i] == 4) {
          s[i][j] = f1(y);
        } else if (arrayHas(new Integer[] { 5, 7, 8, 10, 12, 13, 14, 16 }, (int) c[i])) {
          s[i][j] = f2(y);
        } else {
          s[i][j] = f3(y);
        }
        System.out.printf("%-10.5f", s[i][j]);
      }
      System.out.println();
    }
  }

  private static double f1(double x) {
    return Math.pow(Math.sin((x + 0.5) / 2), 0.5 / ((x * (x + 0.5) + 1) * 2));
  }

  private static double f2(double x) {
    return Math.log(Math.pow(Math.pow(Math.tan(x), 2), 2));
  }

  private static double f3(double x) {
    return Math
        .sin(Math.pow(0.75 * (Math.pow((3 - Math.cbrt(x)) / Math.asin((x + 5) / 2 * Math.E + 1), 3) + Math.PI),
            Math.atan(1 / (Math.pow(Math.E, Math.abs(x))))));
  }

  /**
   * Checks whether an element is present in an array
   * 
   * @param <T> element/array type
   * @param a   given array
   * @param e   given element
   */
  private static <T> boolean arrayHas(T[] a, T e) {
    for (T x : a)
      if (x == e)
        return true;
    return false;
  }

  /**
   * Returns random double [a ; b)
   * 
   * @param a lower bound (inclusive)
   * @param b upper bound (non-inclusive)
   */
  private static double randomDouble(double a, double b) {
    return Math.random() * (b - a) + a;
  }
}
