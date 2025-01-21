package br.dev.ferreiras.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveElement {

  private static final Logger logger = Logger.getLogger(RemoveElement.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    int[] numbers = GenerateArraysOfNumbers.generateUniqueArrays(50);
    logger.log(Level.INFO, "::: ORIGINAL ARRAY: -> {0} :::", Arrays.toString(numbers));

    int ceiling = numbers.length-1;
    Random random = new Random();
    int element = numbers[(random.nextInt(ceiling))];

    int[] result = removeElement(numbers, element);
    logger.log(Level.INFO, "::: ELEMENT TO BE REMOVED: -> {0} :::", element);
    logger.log(Level.INFO, "::: MODIFIED ARRAY #1: -> {0} :::", Arrays.toString(result));

    result = removingElement(numbers, element);
    logger.log(Level.INFO, "::: MODIFIED ARRAY #2: -> {0} :::", Arrays.toString(result));
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);

  }

  private static int[] removeElement(int[] numbers, int element) {

    List<Integer> list = new ArrayList<>();
    for (int number : numbers) {
      if (number == element) {
        continue;
      } else {
        list.add(number);
      }
    }

    return list.stream().mapToInt(x -> x).sorted().toArray();
  }

  private static int[] removingElement(int[] numbers, int element) {

    int count = 0;
    for (int number : numbers) {
      if (number == element) count++;
    }

    int size = numbers.length;
    int[] resizedNumbers = new int[size - count];

    count = 0;

    for (int number : numbers) {
      if (number != element) {
        resizedNumbers[count++] = number;
      }
    }

    Arrays.sort(resizedNumbers);
    return resizedNumbers;
  }
}
