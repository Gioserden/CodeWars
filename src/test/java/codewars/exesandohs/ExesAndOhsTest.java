package codewars.exesandohs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Default test.
 */
public class ExesAndOhsTest {

  /**
   * Default test 1.
   */
  @Test
  public void testSomething1() {
    assertEquals(true, ExesAndOhs.getXo("xxxooo"));
  }

  /**
   * Default test 2.
   **/
  @Test
  public void testSomething2() {
    assertEquals(true, ExesAndOhs.getXo("xxxXooOo"));
  }

  /**
   * Default test 3.
   **/
  @Test
  public void testSomething3() {
    assertEquals(false, ExesAndOhs.getXo("xxx23424esdsfvxXXOOooo"));
  }

  /**
   * Default test 4.
   */
  @Test
  public void testSomething4() {
    assertEquals(false, ExesAndOhs.getXo("xXxxoewrcoOoo"));
  }

  /**
   * Default test 5.
   */
  @Test
  public void testSomething5() {
    assertEquals(false, ExesAndOhs.getXo("XxxxooO"));
  }

  /**
   * Default test 6.
   */
  @Test
  public void testSomething6() {
    assertEquals(true, ExesAndOhs.getXo("zssddd"));
  }

  /**
   * Default test 7.
   */
  @Test
  public void testSomething7() {
    assertEquals(false, ExesAndOhs.getXo("Xxxxertr34"));
  }

  /**
   * Default test 8.
   */
  @Test
  public void testSomething8() {
    assertEquals(false, ExesAndOhs.getXo("5XHS"));
  }
}
