package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Palindrome {

  private static final Logger logger = Logger.getLogger(Palindrome.class.getName());

  public static void main(String[] args) {
    long start = System.nanoTime();
    String string = "jaaj";

    boolean isPalindrome = checkString(string);

    logger.log(Level.INFO, "::: IS PALINDROME?: -> {0} :::", isPalindrome);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static boolean checkString(String string) {

    int right = string.length() - 1;

    for (int left = 0; left < string.length(); left++) {
      if (string.charAt(left) != string.charAt(right)) return false;
      right--;
    }

    return true;
  }
}
