package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmallestElement {

  private static final Logger logger = Logger.getLogger(SmallestElement.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    GenerateArraysOfNumbers instance = GenerateArraysOfNumbers.getInstance();
    int[] numbers = instance.generateArrays(100);

    logger.log(Level.INFO, "Numbers: {0}", Arrays.toString(numbers));
    int smallest = smallestElement(numbers);

    logger.log(Level.INFO, "::: smallest: -> {0} :::", smallest);

    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start)/ 1_000_000);

  }

  private static int smallestElement(int[] numbers) {

    int smallest = Integer.MAX_VALUE;

    for (int number : numbers) {
      smallest = Math.min(smallest, number);
    }
    return smallest;
  }

}
