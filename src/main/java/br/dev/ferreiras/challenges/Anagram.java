package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Anagram {

  private static final Logger logger = Logger.getLogger(Anagram.class.getName());

  public static void main(String[] args) {
    long start = System.nanoTime();
    String s = "The quick   brown fox dog  jumps     over the     lazy  dog 123456789";
    String r = "over the brown fox  The quick     123456789    dog  jumps    lazy    dog       ";

    boolean isAnagram = anagramsCheck(s ,r);
    logger.log(Level.INFO, "ARE ANAGRAMS?: {0} :::", isAnagram);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static boolean checkAnagrams(String s, String r) {

    String regex = "\\s+";
    String[] sc = s.split(regex);
    String[] rc = r.split(regex);
    Arrays.sort(sc);
    Arrays.sort(rc);
    StringBuilder scs = new StringBuilder();
    StringBuilder rcr = new StringBuilder();

    for (String word : sc) {
      scs.append(word);
    }

    for (String word : rc) {
      rcr.append(word);
    }

    return scs.toString().contentEquals(rcr);
  }

  private static boolean anagramsCheck(String s, String r) {

    String regex = "\\s+";
    String[] sc = s.split(regex);
    String[] rc = r.split(regex);
    Arrays.sort(sc);
    Arrays.sort(rc);
    StringBuilder scs = new StringBuilder();
    StringBuilder rcr = new StringBuilder();

    for (String string : sc) {
      scs.append(string);
    }
    for (String string : rc) {
      rcr.append(string);
    }

    logger.log(Level.INFO, "::: SCS: {0} :::", scs);
    logger.log(Level.INFO, "::: RCR: {0} :::", rcr);

    return scs.toString().contentEquals(rcr);
  }
}
