package codewars.vowelcount;

/**
 * Count vowels.
 */
final class Vowels {

  /**
   * Default constructor.
   */
  private Vowels() {
  }

  /**
   * Counts the number of vowels of a given string.
   *
   * @param str the given string.
   * @return the vowels count.
   */
  static int getCount(final String str) {
    int vowelsCount = 0;
    String[] strings = str.split("");
    for (String string : strings) {
      if (string.equals("a") || string.equals("e") || string.equals("i") || string.equals("o")
          || string.equals("u")) {
        vowelsCount++;
      }
    }
    return vowelsCount;
  }
}
