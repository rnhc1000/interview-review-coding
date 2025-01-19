package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NumberOfCharacters {

  private static final Logger logger = Logger.getLogger(NumberOfCharacters.class.getName());

  public static void main(String[] args) {
    long start = System.nanoTime();

    String string = "Ricardo Alves Ferreira Silva";

    int size = returnNumberOfCharacters(string);

    logger.log(Level.INFO, "::: NUMBER OF CHARACTERS: -> {0} :::", size);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static int returnNumberOfCharacters(String string) {

    String regex = "\\s+";
    String[] words = string.split(regex);
    int size = 0;
    for (String word : words) {
      size += word.length();
    }
    logger.log(Level.INFO, "::: WORDS ONLY {0} :::",Arrays.toString(words));

    return size;
  }
}
