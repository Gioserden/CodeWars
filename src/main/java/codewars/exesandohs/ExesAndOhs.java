package codewars.exesandohs;

/**
 * Count 'x' and 'o' and verify is they are equals.
 */
public final class ExesAndOhs {

  /**
   * Default constructor.
   */
  private ExesAndOhs() {
  }

  /**
   * Count 'x' and 'o' and verify is they are equals.
   *
   * @param str the input string.
   * @return true if they are equals false otherwise.
   */
  public static boolean getXo(String str) {
    int xCount = 0, oCount = 0;
    String[] strings = str.toLowerCase().split("");
    for (String string : strings) {
      if (string.equals("x")) {
        xCount++;
      } else if (string.equals("o")) {
        oCount++;
      }
    }
    return xCount + oCount == 0 || xCount == oCount;
  }
}
