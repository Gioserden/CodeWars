package codewars.countpositivessumnegatives;

/**
 * Count positives and sum negatives.
 */
public final class CountSum {

  /**
   * Default constructor.
   */
  private CountSum() {
  }

  /**
   * Count positives and sum negatives.
   *
   * @param input list of number to process.
   * @return a list of result of operations.
   */
  public static int[] countPositivesSumNegatives(int[] input) {

    if (input != null && input.length != 0) {
      int count = 0;
      int sum = 0;
      for (int anInput : input) {
        if (anInput < 0) {
          sum += anInput;
        } else if (anInput > 0) {
          count++;
        }
      }
      return new int[]{count, sum};
    } else {
      return new int[0];
    }
  }
}
