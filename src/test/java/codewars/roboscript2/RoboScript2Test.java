package codewars.roboscript2;

/**
 * Task Write an interpreter for RS1 called execute() which accepts 1 required argument code, the
 * RS1 program to be executed. The interpreter should return a string representation of the smallest
 * 2D grid containing the full path that the MyRobot has walked on (explained in more detail
 * later).
 *
 * Initially, the robot starts at the middle of a 1x1 grid. Everywhere the robot walks it will leave
 * a path "*". If the robot has not been at a particular point on the grid then that point will be
 * represented by a whitespace character " ". So if the RS1 program passed in to execute() is empty
 * then:
 *
 * RoboScript.execute(""); // => "*" The robot understand 3 major commands:
 *
 * F - Move forward by 1 step in the direction that it is currently pointing. Initially, the robot
 * faces to the right. L - Turn "left" (i.e. rotate 90 degrees anticlockwise) R - Turn "right" (i.e.
 * rotate 90 degrees clockwise) As the robot moves forward, if there is not enough space in the
 * grid, the grid should expand accordingly. So:
 *
 * RoboScript.execute("FFFFF"); // => "******" As you will notice, 5 F commands in a row should
 * cause your interpreter to return a string containing 6 "*"s in a row. This is because initially,
 * your robot is standing at the middle of the 1x1 grid facing right. It leaves a mark on the spot
 * it is standing on, hence the first "*". Upon the first command, the robot moves 1 unit to the
 * right. Since the 1x1 grid is not large enough, your interpreter should expand the grid 1 unit to
 * the right. The robot then leaves a mark on its newly arrived destination hence the second "*". As
 * this process is repeated 4 more times, the grid expands 4 more units to the right and the robot
 * keeps leaving a mark on its newly arrived destination so by the time the entire program is
 * executed, 6 "squares" have been marked "*" from left to right.
 *
 * Each row in your grid must be separated from the next by a CRLF (\r\n). Let's look at another
 * example:
 *
 * RoboScript.execute("FFFFFLFFFFFLFFFFFLFFFFFL"); // => "******\r\n*    *\r\n*    *\r\n*    *\r\n*
 * *\r\n******"
 *
 * /* The grid looks like this: ***** * * * * *****
 *
 * The robot moves 5 units to the right, then turns left, then moves 5 units upwards, then turns
 * left again, then moves 5 units to the left, then turns left again and moves 5 units downwards,
 * returning to the starting point before turning left one final time. Note that the marks do not
 * disappear no matter how many times the robot steps on them, e.g. the starting point is still
 * marked "*" despite the robot having stepped on it twice (initially and on the last step).
 *
 * Another example:
 *
 * The grid looks like this:
 *
 * ******
 * *    *
 * *    *
 * *    *
 * *    *
 * ******
 *
 * RoboScript.execute("LFFFFFRFFFRFFFRFFFFFFF"); // => "    ****\r\n    *  *\r\n    *
 * *\r\n********\r\n    *   \r\n    *   "
 *
 The robot moves 5 units to the right, then turns left, then moves 5 units upwards, then turns left again, then moves 5 units to the left, then turns left again and moves 5 units downwards, returning to the starting point before turning left one final time. Note that the marks do not disappear no matter how many times the robot steps on them, e.g. the starting point is still marked "*" despite the robot having stepped on it twice (initially and on the last step).

 Another example:

 RoboScript.execute("LFFFFFRFFFRFFFRFFFFFFF"); // => "    ****\r\n    *  *\r\n    *  *\r\n********\r\n    *   \r\n    *   "

 /*
 The grid looks like this:
 ****
 *  *
 *  *
 ********
 *
 *
 */

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

/**
 Initially the robot turns left to face upwards, then moves upwards 5 squares, then turns right and moves 3 squares, then turns right again (to face downwards) and move 3 squares, then finally turns right again and moves 7 squares.

 Since you've realised that it is probably quite inefficient to repeat certain commands over and over again by repeating the characters (especially the F command - what if you want to move forwards 20 steps?), you decide to allow a shorthand notation in the RS1 specification which allows your customers to postfix a non-negative integer onto a command to specify how many times an instruction is to be executed:

 Fn - Execute the F command n times (NOTE: n may be more than 1 digit long!)
 Ln - Execute L n times
 Rn - Execute R n times
 So the example directly above can also be written as:

 LF5RF3RF3RF7
 */
public class RoboScript2Test {

  @Test
  public void sampleTests() {
    assertPathEquals("", "*");
    assertPathEquals("FFFFF", "******");
    assertPathEquals("FFFFFLFFFFFLFFFFFLFFFFFL", "******\r\n*    *\r\n*    *\r\n*    *\r\n*    *\r\n******");
    assertPathEquals("LFFFFFRFFFRFFFRFFFFFFF", "    ****\r\n    *  *\r\n    *  *\r\n********\r\n    *   \r\n    *   ");
    assertPathEquals("LF5RF3RF3RF7", "    ****\r\n    *  *\r\n    *  *\r\n********\r\n    *   \r\n    *   ");
  }


  private static void assertPathEquals(String code, String expected) {
    String  actual   = RoboScript2.execute(code);
    boolean areEqual = expected.equals(actual);

    if (!areEqual) {
      System.out.println(String.format(
          "--------------\nYou returned:\n%s\nExpected path of MyRobot:\n%s\n--------------\n",
          actual, expected));
    }
    assertTrue("Nope...", areEqual);
  }

}
