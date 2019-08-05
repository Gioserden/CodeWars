package codewars.simpleassembler;

/**
 * This is the first part of this kata series. Second part is here.
 * https://www.codewars.com/kata/assembler-interpreter-part-ii/
 *
 * We want to create a simple interpreter of assembler which will support the following
 * instructions:
 *
 * mov x y - copies y (either a constant value or the content of a register) into register x inc x -
 * increases the content of register x by one dec x - decreases the content of register x by one jnz
 * x y - jumps to an instruction y steps away (positive means forward, negative means backward), but
 * only if x (a constant or a register) is not zero Register names are alphabetical (letters only).
 * Constants are always integers (positive or negative).
 *
 * Note: the jnz instruction moves relative to itself. For example, an offset of -1 would continue
 * at the previous instruction, while an offset of 2 would skip over the next instruction.
 *
 * The function will take an input list with the sequence of the program instructions and will
 * return a dictionary with the contents of the registers.
 *
 * Also, every inc/dec/jnz on a register will always be followed by a mov on the register first, so
 * you don't need to worry about uninitialized registers.
 *
 * SimpleAssebmler.interpret(new String[]{"mov a 5","inc a","dec a","dec a","jnz a -1","inc a"});
 *
 * ''' visualized: mov a 5 inc a dec a dec a jnz a -1 inc a ''''
 *
 * The above code will:
 *
 * set register a to 5, increase its value by 1, decrease its value by 2, then decrease its value
 * until it is zero (jnz a -1 jumps to the previous instruction if a is not zero) and then increase
 * its value by 1, leaving register a at 1
 *
 * So, the function should return
 *
 * {a=1}
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;

/**
 * Class of test.
 */
public class SimpleAssemblerTest {

  /**
   * Test 1.
   */
  @Test
  public void simpleOne() {
    String[] program = new String[]{"mov a 5", "inc a", "dec a", "dec a", "jnz a -1", "inc a"};
    Map<String, Integer> out = new HashMap<String, Integer>();
    out.put("a", 1);
    assertEquals(out, SimpleAssembler.interpret(program));
  }

  /**
   * Test 2.
   */
  @Test
  public void simpleTwo() {
    String[] program = new String[]{"mov a -10", "mov b a", "inc a", "dec b", "jnz a -2"};
    Map<String, Integer> out = new HashMap<String, Integer>();
    out.put("a", 0);
    out.put("b", -20);
    assertEquals(out, SimpleAssembler.interpret(program));
  }

  /**
   * Test 3.
   */
  @Test
  public void simpleThree() {
    String[] program = new String[]{"mov a 1", "mov b 1", "mov c 0", "mov d 26", "jnz c 2",
        "jnz 1 5", "mov c 7", "inc d", "dec c", "jnz c -2", "mov c a", "inc a", "dec b", "jnz b -2",
        "mov b c", "dec d", "jnz d -6", "mov c 18", "mov d 11", "inc a", "dec d", "jnz d -2",
        "dec c", "jnz c -5"};
    Map<String, Integer> out = new HashMap<String, Integer>();
    out.put("a", 318009);
    out.put("b", 196418);
    out.put("c", 0);
    out.put("d", 0);
    assertEquals(out, SimpleAssembler.interpret(program));
  }

  /**
   * Test 4.
   */
  @Test
  public void simpleFour() {
    String[] program = new String[]{"mov d 100", "dec d", "mov b d", "jnz b -2", "inc d", "mov a d",
        "jnz 5 10", "mov c a"};
    Map<String, Integer> out = new HashMap<String, Integer>();
    out.put("a", 1);
    out.put("b", 0);
    out.put("d", 1);
    assertEquals(out, SimpleAssembler.interpret(program));
  }

  /**
   * Test 5.
   */
  @Test
  public void simpleFive() {
    String[] program = new String[]{"mov c 12", "mov b 0", "mov a 200", "dec a", "inc b",
        "jnz a -2", "dec c", "mov a b", "jnz c -5", "jnz 0 1", "mov c a"};
    Map<String, Integer> out = new HashMap<String, Integer>();
    out.put("a", 409600);
    out.put("b", 409600);
    out.put("c", 409600);
    assertEquals(out, SimpleAssembler.interpret(program));
  }
}
