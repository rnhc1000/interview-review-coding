package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LongestWord {

  private static final Logger logger = Logger.getLogger(SumAllElements.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();

    String words = "The quick brown fox dog       jumps over     the lazy dog, definitely, undoubtedly, 123456789101112";
    int longest = returnLargestWord(words);

    logger.log(Level.INFO, "::: Largest word: -> {0} :::", longest);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start)/ 1_000_000);
  }

  private static int returnLargestWord(String words) {

    String regex = "\\s+";
    String[] word = words.split(regex);
    int size = Integer.MIN_VALUE;
    for (String w : word) {
      size = Math.max(w.length(), size);
    }

    return size;
  }
}