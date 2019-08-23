package codewars.roboscript1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 *  public static String highlight(String code) {
 * return code
 * replaceAll("(F+)", "<span style=\"color: pink\">$1</span>")
 * replaceAll("(L+)", "<span style=\"color: red\">$1</span>")
 * replaceAll("(R+)", "<span style=\"color: green\">$1</span>")
 * replaceAll("(\\d+)", "<span style=\"color: orange\">$1</span>");
 * }
 */
public class RoboScriptTest {

  @Test
  public void test1() {
    System.out.println("Code without syntax highlighting:   F3RF5LF7");
    System.out.println("Your code with syntax highlighting: " + RoboScript.highlight("F3RF5LF7"));
    System.out.println(
        "Expected syntax highlighting:       <span style=\"color: pink\">F</span><span style=\"color: orange\">3</span><span style=\"color: green\">R</span><span style=\"color: pink\">F</span><span style=\"color: orange\">5</span><span style=\"color: red\">L</span><span style=\"color: pink\">F</span><span style=\"color: orange\">7</span>");
    assertEquals(
        "<span style=\"color: pink\">F</span><span style=\"color: orange\">3</span><span style=\"color: green\">R</span><span style=\"color: pink\">F</span><span style=\"color: orange\">5</span><span style=\"color: red\">L</span><span style=\"color: pink\">F</span><span style=\"color: orange\">7</span>",
        RoboScript.highlight("F3RF5LF7"));
  }

  @Test
  public void test2() {
    System.out.println("Code without syntax highlighting:   FFFR345F2LL");
    System.out.println("Your code with syntax highlighting: " + RoboScript.highlight("FFFR345F2LL"));
    System.out.println("Expected syntax highlighting:       <span style=\"color: pink\">FFF</span><span style=\"color: green\">R</span><span style=\"color: orange\">345</span><span style=\"color: pink\">F</span><span style=\"color: orange\">2</span><span style=\"color: red\">LL</span>");
    assertEquals("<span style=\"color: pink\">FFF</span><span style=\"color: green\">R</span><span style=\"color: orange\">345</span><span style=\"color: pink\">F</span><span style=\"color: orange\">2</span><span style=\"color: red\">LL</span>", RoboScript.highlight("FFFR345F2LL"));
  }

  @Test
  public void test3() {
    System.out.println("Code without syntax highlighting:   12345678");
    System.out.println("Your code with syntax highlighting: " + RoboScript.highlight("12345678"));
    System.out.println("Expected syntax highlighting:       <span style=\"color: orange\">12345678</span>");
    assertEquals("<span style=\"color: orange\">12345678</span>", RoboScript.highlight("12345678"));
  }

  @Test
  public void test4() {
    System.out.println("Code without syntax highlighting:   FFFFFFFFF");
    System.out.println("Your code with syntax highlighting: " + RoboScript.highlight("FFFFFFFFF"));
    System.out.println("Expected syntax highlighting:       <span style=\"color: pink\">FFFFFFFFF</span>");
    assertEquals("<span style=\"color: pink\">FFFFFFFFF</span>", RoboScript.highlight("FFFFFFFFF"));
  }
}
