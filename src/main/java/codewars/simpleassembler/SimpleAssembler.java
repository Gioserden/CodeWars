package codewars.simpleassembler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Clever solution.
*
* import java.util.*;
*
*  public class SimpleAssembler {
*
*  // Get s as a constant or as a register value
*  private static int getConstOrRegValue(final Map<String,Integer> regMap, final String s) {
*    try { return Integer.parseInt(s); } catch (NumberFormatException ex) { return regMap.get(s); }
*  }
*
*  public static Map<String, Integer> interpret(final String[] program) {
*
*    final Map<String,Integer> regMap = new HashMap<>();
*
*    for (int i = 0; i < program.length; i++) {
*      final String cmdParts[] = program[i].split(" ");
*      switch (cmdParts[0]) {
*        case "mov": regMap.put(cmdParts[1], getConstOrRegValue(regMap, cmdParts[2])); break;
*        case "inc": regMap.put(cmdParts[1], regMap.get(cmdParts[1])+1); break;
*        case "dec": regMap.put(cmdParts[1], regMap.get(cmdParts[1])-1); break;
*        case "jnz": if (getConstOrRegValue(regMap, cmdParts[1]) != 0) i += Integer.parseInt(cmdParts[2]) - 1; break;
*      }
*    }
*
*    return regMap;
*  }
*}
*/
public final class SimpleAssembler {

  private static final int COMMAND = 0;
  private static final int REGISTER = 1;
  private static final int CONSTANT = 2;

  /**
   * Default constructor.
   */
  private SimpleAssembler() {

  }

  /**
   * Interpret the instructions.
   *
   * @param program a list of instructions.
   * @return the interpretation.
   */
  public static Map<String, Integer> interpret(String[] program) {

    final List<String[]> instructions = new ArrayList<>();
    final Map<String, Integer> execution = new HashMap<>();

    // divide instructions.
    for (String aProgram : program) {
      String[] instruction = aProgram.split(" ");
      instructions.add(instruction);
    }

    // review and execute each instruction.
    for (int i = 0; i < instructions.size(); i++) {
      String[] instruction = instructions.get(i);
      String register = instruction[REGISTER];

      // make sure first instruction have a mov with valid number.
      if (i == 0 && instruction[COMMAND].equals("mov")) {
        // saving first register
        try {
          //saving first data.
          execution.put(register, Integer.parseInt(instruction[2]));
        } catch (NumberFormatException e) {
          return null;
        }
        continue;
      }
      switch (instruction[COMMAND]) {
        case "mov":
          if (isNumber(instruction[CONSTANT])) {
            execution.put(register, Integer.parseInt(instruction[CONSTANT]));
            break;
          }
          execution.put(instruction[REGISTER], execution.get(instruction[CONSTANT]));
          break;
        case "inc":
          execution.put(instruction[REGISTER], execution.get(instruction[REGISTER]) + 1);
          break;
        case "dec":
          execution.put(instruction[REGISTER], execution.get(instruction[REGISTER]) - 1);
          break;
        case "jnz":
          int registerConstant =
              isNumber(instruction[REGISTER]) ? Integer.parseInt(instruction[REGISTER])
                  : execution.get(instruction[REGISTER]);

          int constant = Integer.parseInt(instruction[CONSTANT]);

          if (registerConstant != 0) {
            if (constant > instructions.size()) {
              i = instructions.size() - 1;
            }
            i = (i - 1);
          }
          break;
        default:
          return null;
      }
    }
    return execution;
  }

  /**
   * Verify that a string is a number.
   *
   * @param var the string.
   * @return tru if string is number, false otherwise.
   */
  private static boolean isNumber(String var) {
    try {
      Integer.parseInt(var);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
