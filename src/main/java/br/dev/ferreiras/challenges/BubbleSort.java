package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSort {

  private static final Logger logger = Logger.getLogger(BubbleSort.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    int[] numbers = GenerateArraysOfNumbers.generateUniqueArrays(30);
    logger.log(Level.INFO, "BEFORE BUBBLE SORT: {0}  :::", Arrays.toString(numbers));

    int[] bubbleSorted = bubbleSort(numbers);

    logger.log(Level.INFO, "AFTER BUBBLE SORT: {0}  :::", Arrays.toString(bubbleSorted));
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static int[] bubbleSort(int[] numbers) {
    int right  = numbers.length - 1;

    for (int i = right; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if(numbers[j] > numbers[j + 1]) {
          numbers[j] = numbers[j] ^ numbers[j + 1];
          numbers[j + 1] = numbers[j] ^ numbers[j + 1];
          numbers[j] = numbers[j] ^ numbers[j + 1];
        }
      }
    }
    return numbers;
  }
}
