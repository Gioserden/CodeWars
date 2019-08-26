package codewars.roboscript1;

/**
 * RoboScript #1 - Implement Syntax Highlighting Disclaimer The story presented in this Kata Series
 * is purely fictional; any resemblance to actual programming languages, products, organisations or
 * people should be treated as purely coincidental.
 *
 * About this Kata Series This Kata Series is based on a fictional story about a computer scientist
 * and engineer who owns a firm that sells a toy robot called MyRobot which can interpret its own
 * (esoteric) programming language called RoboScript. Naturally, this Kata Series deals with the
 * software side of things (I'm afraid Codewars cannot test your ability to build a physical
 * robot!).
 *
 * Story You are a computer scientist and engineer who has recently founded a firm which sells a toy
 * product called MyRobot which can move by receiving a set of instructions by reading a file
 * containing a script. Initially you have planned the robot to be able to interpret JavaScript
 * files for its movement instructions but you later decided that it would make MyRobot too hard to
 * operate for most customers out there who aren't even computer programmers in the first place. For
 * this reason, you have decided to invent a new (esoteric) scripting language called RoboScript
 * which has a much simpler syntax so non-computer programmers can easily learn how to write scripts
 * in this language which would enable them to properly operate MyRobot. However, you are currently
 * at the initial stage of inventing this new Esolang. The first step to popularize this (esoteric)
 * scripting language is naturally to invent a new editor for it which provides syntax highlighting
 * for this language so your customers feel like they are writing a proper program when they are
 * writing scripts for MyRobot.
 *
 * Task Your MyRobot-specific (esoteric) scripting language called RoboScript only ever contains the
 * following characters: F, L, R, the digits 0-9 and brackets (( and )). Your goal is to write a
 * function highlight which accepts 1 required argument code which is the RoboScript program passed
 * in as a string and returns the script with syntax highlighting. The following commands/characters
 * should have the following colors:
 *
 * F - Wrap this command around <span style="color: pink"> and </span> tags so that it is
 * highlighted pink in our editor L - Wrap this command around <span style="color: red"> and </span>
 * tags so that it is highlighted red in our editor R - Wrap this command around <span style="color:
 * green"> and </span> tags so that it is highlighted green in our editor Digits from 0 through 9 -
 * Wrap these around <span style="color: orange"> and </span> tags so that they are highlighted
 * orange in our editor Round Brackets - Do not apply any syntax highlighting to these characters
 * For example:
 *
 * RoboScript.highlight("F3RF5LF7"); // => "<span style=\"color: pink\">F</span><span style=\"color:
 * orange\">3</span><span style=\"color: green\">R</span><span style=\"color: pink\">F</span><span
 * style=\"color: orange\">5</span><span style=\"color: red\">L</span><span style=\"color:
 * pink\">F</span><span style=\"color: orange\">7</span>" And for multiple characters with the same
 * color, simply wrap them with a single span tag of the correct color:
 *
 * RoboScript.highlight("FFFR345F2LL"); // => "<span style=\"color: pink\">FFF</span><span
 * style=\"color: green\">R</span><span style=\"color: orange\">345</span><span style=\"color:
 * pink\">F</span><span style=\"color: orange\">2</span><span style=\"color: red\">LL</span>" Note
 * that the use of span tags must be exactly the same format as demonstrated above. Even if your
 * solution produces the same visual result as the expected answers, if you miss a space betwen
 * "color:" and "green", for example, you will fail the tests.
 */
final class RoboScript {

  /**
   * Default Constructor.
   */
  private RoboScript() {

  }

  /**
   * The is the main assemble.
   *
   * @param code The expected code to work with.
   * @return the code that have been worked to JavaScript.
   */
  public static String highlight(String code) {
    System.out.println();
    String finalWord = "";
    String[] lettersList = code.split("");
    for (int i = 0; i < lettersList.length; i++) {
      String currentLetter = lettersList[i];

      if (i == 0) {
        if (currentLetter.equals("(") || currentLetter.equals(")")) {
          finalWord = finalWord.concat(currentLetter);
          continue;
        }
        finalWord = finalWord.concat(String
            .format("<span style=\"color: %s\">%s", witchColor(currentLetter), currentLetter));
        continue;
      }

      if (currentLetter.equals("(") || currentLetter.equals(")")) {
        if (lettersList[i - 1].equals("(") || lettersList[i - 1].equals(")")) {
          finalWord = finalWord.concat(currentLetter);
          continue;
        }
        finalWord = finalWord.concat(String.format("</span>%s", currentLetter));
        continue;
      }

      if (witchColor(currentLetter).equals(witchColor(lettersList[i - 1])) && !lettersList[i - 1]
          .equals(")") && !lettersList[i - 1].equals("(")) {
        if (i == lettersList.length - 1) {
          finalWord = finalWord.concat(String.format("%s</span>", currentLetter));
          continue;
        }
        finalWord = finalWord.concat(currentLetter);
        continue;
      }

      if ((i) == lettersList.length - 1) {
        if (lettersList[i - 1].equals("(") || lettersList[i - 1].equals(")") && !currentLetter
            .equals("(") && !currentLetter.equals("(")) {
          finalWord = finalWord.concat(String
              .format("<span style=\"color: %s\">%s</span>", witchColor(currentLetter),
                  currentLetter));
          continue;
        }
        finalWord = finalWord.concat(String
            .format("</span><span style=\"color: %s\">%s</span>", witchColor(currentLetter),
                currentLetter));
        continue;
      }

      if (lettersList[i - 1].equals("(") || lettersList[i - 1].equals(")") && !currentLetter
          .equals("(") && !currentLetter.equals("(")) {
        finalWord = finalWord.concat(String
            .format("<span style=\"color: %s\">%s", witchColor(currentLetter), currentLetter));
        continue;
      }

      finalWord = finalWord.concat(
          String.format("</span><span style=\"color: %s\">%s", witchColor(currentLetter),
              currentLetter));
    }
    return finalWord;
  }

  /**
   * Private Method for main operation.
   *
   * @param letter The letter to work with.
   * @return the current color of letter.
   */
  private static String witchColor(final String letter) {
    switch (letter) {
      case "F":
        return "pink";
      case "L":
        return "red";
      case "R":
      return "green";
      default:
        return "orange";
    }
  }
}
