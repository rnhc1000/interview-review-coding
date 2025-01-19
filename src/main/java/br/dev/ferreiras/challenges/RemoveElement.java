package br.dev.ferreiras.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RemoveElement {

  private static final Logger logger = Logger.getLogger(RemoveElement.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    int[] numbers = GenerateArraysOfNumbers.generateUniqueArrays(50);
    logger.log(Level.INFO, "::: ORIGINAL ARRAY: -> {0} :::", Arrays.toString(numbers));

    int index = 7;
    int[] result = removeElement(numbers, index);

    logger.log(Level.INFO, "::: MODIFIED ARRAY: -> {0} :::", Arrays.toString(result));
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);

  }

  private static int[] removeElement(int[] numbers, int index) {

    if (index > numbers.length-1) return new int[]{};
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < numbers.length; i++) {
      if (i == index) {
        continue;
      } else {
        list.add(numbers[i]);
      }
    }

    return list.stream().mapToInt(x -> x).toArray();
  }
}
