package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySearch {

  private static final Logger logger = Logger.getLogger(BubbleSort.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();

    int[] numbers = GenerateArraysOfNumbers.generateUniqueSortedArrays(100);
    int number = (int) (Math.random() * 100);
    logger.log(Level.INFO, "::: NUMBERS: {0} :::", Arrays.toString(numbers));
    logger.log(Level.INFO, "::: RANDOM N: {0} :::", number);

    int index = binarySearchIndex(numbers, number);
    logger.log(Level.INFO, "NUMBER FOUND AT POSITION: {0}  :::", index);
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static int binarySearchIndex(int[] numbers, int number) {

    int right = numbers.length - 1;
    int left = 0;
    Arrays.sort(numbers);

    while (left < right) {

      int middle = left + (right - left) / 2;

      if (numbers[middle] == number) {

        return middle;

      } else if (numbers[middle] > number) {

        right = middle;

      } else {

        left = middle + 1;

      }
    }

    return -1;
  }
}
