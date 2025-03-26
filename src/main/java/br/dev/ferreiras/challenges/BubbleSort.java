package br.dev.ferreiras.challenges;

import java.util.Arrays;


public class BubbleSort {


  public static void main(String[] args) {

    Logger logger = Logger.getInstance();
    long start = System.nanoTime();
    int[] numbers = GenerateArraysOfNumbers.generateUniqueArrays(30);
    logger.log("::: BEFORE BUBBLE SORT: :::", Arrays.toString(numbers));

    int[] bubbleSorted = bubbleSort(numbers);
    System.out.println(Arrays.toString(bubbleSorted));
    logger.log("::: AFTER BUBBLE SORT: :::", Arrays.toString(bubbleSorted));
    logger.log("::: TIME SPENT: ::: ", (String.valueOf((System.nanoTime() - start) / 1_000_000) + "ms"));
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
