package br.dev.ferreiras.challenges;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReverseString {

  private static final Logger logger = Logger.getLogger(NumberOfCharacters.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    String[] strings = {"Ricardo", "Alves", "Ferreira", "Silva"};
    logger.log(Level.INFO, "::: GIVEN  STRING: -> {0} :::", Arrays.toString(strings));
    String[] result = revertString(strings);

    logger.log(Level.INFO, "::: REVERSED STRING: -> {0} :::", Arrays.toString(result));
    result = fullyRevertedString(strings);
    logger.log(Level.INFO, "::: REVERSED STRING: -> {0} :::", Arrays.toString(result));

    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static String[] revertString(String[] strings) {
    Deque<String> queue = new ArrayDeque<>();
    List<String> reverse = new ArrayList<>();
    for (String string : strings) {
      queue.push(string);
    }
    while (!queue.isEmpty()) {
      reverse.add(queue.pop());
    }
    return reverse.toArray(new String[0]);
  }

  private static String[] fullyRevertedString(String[] strings) {
    Deque<Character> queue = new ArrayDeque<>();
    List<String> reverse = new ArrayList<>();

    StringBuilder sb = new StringBuilder();
    for (String string : strings) {
      for (char ch : string.toCharArray()) {
        queue.push(ch);
      }
      while (!queue.isEmpty()) {
        sb.append(queue.pop());
      }
      reverse.add(sb.toString());
      sb = new StringBuilder();
    }

      return reverse.toArray(new String[0]);
    }
  }
