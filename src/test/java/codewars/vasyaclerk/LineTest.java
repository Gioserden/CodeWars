package codewars.vasyaclerk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test Class.
 */
public class LineTest {

  /**
   * Test one.
   */
  @Test
  public void test1() {
    assertEquals("YES", Line.tickets(new int[]{25, 25, 50}));
  }

  /**
   * test two.
   */
  @Test
  public void test2() {
    assertEquals("NO", Line.tickets(new int[]{25, 100}));
  }

  /**
   * Test tree.
   */
  @Test
  public void test3() {
    assertEquals("YES", Line.tickets(new int[]{25, 25, 50}));
  }

  /**
   * Test four.
   */
  @Test
  public void test4() {
    assertEquals("NO", Line.tickets(new int[]{25, 25, 50, 50, 100}));
  }

  /**
   * test five.
   */
  @Test
  public void test5() {
    assertEquals("YES", Line.tickets(new int[]{25, 25, 50, 50, 25, 100}));
  }
}
