package br.dev.ferreiras.challenges;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LongestSubstring {

  private static final Logger logger = Logger.getLogger(LongestSubstring.class.getName());


  public static void main(String[] args) {


    long start = System.nanoTime();
    String string = "abcbacbb";
    String longest = findLongestSubstring(string);


    logger.log(Level.INFO, "LONGEST SEQUENCE: {0}  :::", longest);
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static String findLongestSubstring(String string) {

    Map<Character, Integer> map = new HashMap<>();

    String result = "";
    int start = 0;
    for (int i = 0; i < string.length(); i++) {

      char currentChar = string.charAt(i);
      if (map.containsKey(currentChar)) {

        start = Math.max(map.get(currentChar) + 1, start);
      }
      if (result.length() < i - start + 1) {
        result = string.substring(start, i + 1);
      }

//      map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);
      map.put(currentChar, i);

    }

    logger.log(Level.INFO, "::: MAP: {0} :::", map);

    return result;
  }

}
