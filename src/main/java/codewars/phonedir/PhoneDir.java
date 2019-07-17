package codewars.phonedir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * John keeps a backup of his old personal phone book as a text file. On each line of the file he
 * can find the phone number (formated as +X-abc-def-ghij where X stands for one or two digits), the
 * corresponding name between < and > and the address.
 *
 * Unfortunately everything is mixed, things are not always in the same order; parts of lines are
 * cluttered with non-alpha-numeric characters (except inside phone number and name).
 *
 * Examples of John's phone book lines:
 *
 * "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
 *
 * " 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
 *
 * "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n"
 *
 * Could you help John with a program that, given the lines of his phone book and a phone number
 * returns a string for this number : "Phone => num, Name => name, Address => adress"
 *
 * Examples:
 *
 * s = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423
 * ;+1-541-914-3010!\n"
 *
 * phone(s, "1-541-754-3010") should return "Phone => 1-541-754-3010, Name => J Steeve, Address =>
 * 156 Alphand St." It can happen that, for a few phone numbers, there are many people for a phone
 * number -say nb- , then
 *
 * return : "Error => Too many people: nb"
 *
 * or it can happen that the number nb is not in the phone book, in that case
 *
 * return: "Error => Not found: nb"
 *
 * You can see other examples in the test cases.
 *
 * JavaScript random tests completed by @matt c
 *
 * Note Codewars stdout doesn't print part of a string when between < and >
 */
final class PhoneDir {

  /**
   * Default constructor.
   */
  private PhoneDir() {

  }

  /**
   * Principal Method.
   *
   * @param strng The string.
   * @param num The phone number.
   *
   * @return The name, address based on the given number.
   */
  public static String phone(String strng, String num) {

//    -----------------------get numbers-----------------------
    final String regex = "\\d{1,2}-\\d{3}-\\d{3}-\\d{4}";
    final ArrayList<String> numbers = new ArrayList<>();
    final Matcher matcher = Pattern.compile(regex).matcher(strng);
    final Pattern namePattern = Pattern.compile("<(.*)>");
    final List<Map<String, String>> list = new ArrayList<>();
    final String[] data = strng.split("\\r?\\n");
    while (matcher.find()) {
      Map<String, String> map = new HashMap<>();
      map.put("number", matcher.group());
      numbers.add(matcher.group());
      list.add(map);
    }

    final long counter = numbers.stream().filter(n -> n.equals(num)).count();
    if (counter > 2) {
      return "Error => Too many people: ".concat(num);
    } else if (counter == 0) {
      return "Error => Not found: ".concat(num);
    }

    //------------------------------get names---------------------------
    for (int i = 0; i < data.length; i++) {
      String aData = data[i];
      Matcher m = namePattern.matcher(aData);
      m.find();
      list.get(i).put("name", m.group(1));
    }
//---------------------------------get address--------------------------------
    for (int i = 0; i < data.length; i++) {
      data[i] = data[i].replaceAll(list.get(i).get("name"), "")
          .replaceAll(list.get(i).get("number"), "")
          .replaceAll("_", " ").trim()
          .replaceAll("[/+?<>,*;:!$]", "").trim()
          .replaceAll(" {2}", " ").trim();
      if (list.get(i).get("number").equals(num)) {
        strng = String.format("Phone => %s, Name => %s, Address => %s", list.get(i).get("number"),
            list.get(i).get("name"), data[i]);
      }
    }
    return strng;
  }
}
