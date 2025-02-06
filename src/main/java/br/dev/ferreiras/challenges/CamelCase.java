package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Complete the method/function so that it converts dash/underscore delimited words into camel casing. T
he first word within the output should be capitalized only if the original word was capitalized
(known as Upper Camel Case, also often referred to as Pascal case).
The next words should be always capitalized.

Examples
"the-stealth-warrior" gets converted to "theStealthWarrior"

"The_Stealth_Warrior" gets converted to "TheStealthWarrior"

"The_Stealth-Warrior" gets converted to "TheStealthWarrior"
 */
public class CamelCase {

  private static final Logger logger = Logger.getLogger(CamelCase.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    String string = "the_stealth-warrior";

    String response = camelCase(string);

    logger.log(Level.INFO, "ORIGINAL: {0}  :::", string);
    logger.log(Level.INFO, "CAMELCASE: {0}  :::", response);
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static String camelCase(String string) {

    String regex = "[-_]";
    int index = 0;
    StringBuilder sb = new StringBuilder();
    for (char ch : string.toCharArray()) {

      if (ch == '-' || ch == '_') {
        index = string.indexOf(ch);
        logger.log(Level.INFO, "::: UNDERSCORE OR DASH: {0}", index);

      }
//      string.
//      sb.append(ch);
      if (index != 0) {

        sb.deleteCharAt(index);
//        sb.append(cx);
      }
      index = 0;
    }
    logger.log(Level.INFO, "::: REMOVE UNDERSCORE OR DASH: {0}", sb);
    String[] strings = string.split(regex);
    sb.append(strings[0]);
    for (int i = 1; i < strings.length; i++) {
      char cx = Character.toUpperCase(strings[i].charAt(index+1));
//      sb.append(s);

    }

    logger.log(Level.INFO, "::: NO UNDERSCORE OR DASH: {0}", sb.toString());

    logger.log(Level.INFO, "::: STRINGS SPLIT BY _ | -: {0}", Arrays.toString(strings));
    return null;
  }
}
;