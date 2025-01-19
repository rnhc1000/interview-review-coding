package br.dev.ferreiras.challenges;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LargestElement {

  private static final Logger logger = Logger.getLogger(LargestElement.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    Random random = new Random();
    int size = random.nextInt(100);
    logger.log(Level.INFO, "SIZE: {0}", size);

//    GenerateArraysOfNumbers instance = GenerateArraysOfNumbers.getInstance();

    int[] numbers = GenerateArraysOfNumbers.generateArrays(size);
    logger.log(Level.INFO, "NUMBERS: {0}", Arrays.toString(numbers));

    Set<Integer> set = new TreeSet<>();
    for ( int number : numbers) {
      set.add(number);
    }

    int[] array = set.stream().mapToInt(x -> x).toArray();
    logger.log(Level.INFO, "SET: {0}", Arrays.toString(array));
    int largest = largestElement(numbers);

    logger.log(Level.INFO, "::: LARGEST: -> {0} :::", largest);

    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start)/ 1_000_000);

  }

  private static int largestElement(int[] numbers) {
    int largest = Integer.MIN_VALUE;

    for (int number : numbers) {
      largest = Math.max(largest, number);
    }

    return largest;
  }
}
