package codewars.vowelcount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Default tests.
 */
public class VowelsTest {

  /**
   * First test.
   */
  @Test
  public void testCase1() {
    assertEquals("Nope!", 5, Vowels.getCount("abracadabra"));
  }

  /**
   * Second test.
   */
  @Test
  public void testCase2() {
    assertEquals("Nope!", 4, Vowels.getCount("testing vowels"));
  }
}
