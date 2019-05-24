package codewars.countpositivessumnegatives;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * Default test.
 */
public class CountSumTest {

  /**
   * Basic test.
   */
  @Test
  public void countPositivesSumNegativesBasicTest() {
    int[] expectedResult = new int[]{10, -65};
    assertArrayEquals(expectedResult, CountSum.countPositivesSumNegatives(
            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15}));
  }

  /**
   * Using zeros in the list.
   */
  @Test
  public void countPositivesSumNegativesInputWithZeroes() {
    int[] expectedResult = new int[]{8, -50};
    assertArrayEquals(expectedResult, CountSum
        .countPositivesSumNegatives(new int[]{0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14}));
  }

  /**
   * Using an empty list.
   */
  @Test
  public void countPositivesSumNegativesInputEmpty() {
    int[] expectedResult = new int[]{};
    assertArrayEquals(expectedResult, CountSum.countPositivesSumNegatives(new int[]{}));
  }

  /**
   * Using a null list.
   */
  @Test
  public void countPositivesSumNegativesInputNull() {
    int[] expectedResult = new int[]{};
    assertArrayEquals(expectedResult, CountSum.countPositivesSumNegatives(new int[]{}));
  }
}
