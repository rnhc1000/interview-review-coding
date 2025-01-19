package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveWhiteSpaces {

  private static final Logger logger = Logger.getLogger(RemoveWhiteSpaces.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();

    String sentence = " The quick     brown fox   dog jumps     over the    lazy dog";
    logger.log(Level.INFO, "::: GIVEN SENTENCE: -> {0} :::", sentence);

    String result = removeWhiteSpaces(sentence);

    logger.log(Level.INFO, "::: NO WHITES SENTENCE: -> {0} :::", result);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start)/ 1_000_000);
  }

  private static String removeWhiteSpaces(String sentence) {

    String regex = "\\s+";
    String[] noWhites = sentence.split(regex);
    StringBuilder sb = new StringBuilder();
    for (String noWhite : noWhites) {
      sb.append(noWhite);
    }
    return sb.toString();
  }
}
