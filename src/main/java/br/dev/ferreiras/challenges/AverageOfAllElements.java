package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;


public class AverageOfAllElements {

  private static final Logger logger = Logger.getLogger(AverageOfAllElements.class.getName());
  public static void main(String[] args) {
    long start = System.nanoTime();

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    int average = averageElement(numbers);

    logger.log(Level.INFO, "::: average: -> {0} :::", average);
    average = averageElements(numbers);
    logger.log(Level.INFO, "::: average: -> {0} :::", average);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start)/ 1_000_000);


  }

  private static int averageElements(int[] numbers) {

    int sum = 0;
    int size = numbers.length;

    for (int number : numbers) {
      sum += number;
    }

    return sum / size;
  }

  private static int averageElement(int[] numbers) {

    return Arrays.stream(numbers)
        .map(x -> x).sum();
  }
}
