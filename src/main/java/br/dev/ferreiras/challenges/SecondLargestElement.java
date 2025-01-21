package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecondLargestElement {

  private static final Logger logger = Logger.getLogger(SecondLargestElement.class.getName());

  public static void main(String[] args) {
    long start = System.nanoTime();
    Random random = new Random();
    int size = random.nextInt(100);
    logger.log(Level.INFO, "::: SIZE: {0} :::", size);

    int[] numbers = GenerateArraysOfNumbers.generateArrays(size);
    logger.log(Level.INFO, "::: NUMBERS: {0} ::: ", Arrays.toString(numbers));

    int second = secondLargest(numbers);
    logger.log(Level.INFO, "::: SECOND LARGEST NUMBER: {0} ::: ", second);

    second = findSecondLargest(numbers);
    logger.log(Level.INFO, "::: SECOND LARGEST NUMBER: {0} ::: ", second);

    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static int secondLargest(int[] numbers) {

    int[] array = Arrays.stream(numbers).distinct().sorted().toArray();
    logger.log(Level.INFO, "ARRAY: {0}", Arrays.toString(array));
    int size = array.length;

    return (array[size - 2]);
  }

  private static int findSecondLargest(int[] numbers) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int number : numbers) {
      if (largest < number) {
        secondLargest = largest;
        largest = number;
      } else if(number > secondLargest && number != largest) {
        secondLargest = number;
      }

    }

    return secondLargest;
  }
}
