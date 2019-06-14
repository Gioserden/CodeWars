package codewars.vasyaclerk;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema box
 * office standing in a huge line. Each of them has a single 100, 50 or 25 dollars bill. An
 * "Avengers" ticket costs 25 dollars. Vasya is currently working as a clerk. He wants to sell a
 * ticket to every single person in this line. Can Vasya sell a ticket to each person and give the
 * change if he initially has no money and sells the tickets strictly in the order people follow in
 * the line? Return YES, if Vasya can sell a ticket to each person and give the change with the
 * bills he has at hand at that moment. Otherwise return NO.
 *
 * Line.tickets(new int[] {25, 25, 50}) // => YES Line.tickets(new int[]{25, 100}) // => NO. Vasya
 * will not have enough money to give change to 100 dollars Line.tickets(new int[] {25, 25, 50, 50,
 * 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make
 * two bills of 25 from one of 50)
 */
public final class Line {

  /**
   * Default constructor.
   */
  private Line() {
  }

  /**
   * Main logic for changes.
   *
   * @param peopleInLine the number on people on the line.
   * @return True if we have enough money for change.
   */
  public static String tickets(int[] peopleInLine) {
    int quarter = 0;
    int half = 0;
    for (int aPeopleInLine : peopleInLine) {
      if (aPeopleInLine == 25) {
        quarter++;
        continue;
      }
      if (aPeopleInLine == 50 && quarter > 0) {
        half++;
        quarter--;
        continue;
      }
      if (aPeopleInLine == 100) {
        if ((quarter > 0 && half > 0)) {
          quarter--;
          half--;
        } else if (quarter > 2) {
          quarter -= 3;
        } else {
          return "NO";
        }
      }
    }
    return "YES";
  }
}
