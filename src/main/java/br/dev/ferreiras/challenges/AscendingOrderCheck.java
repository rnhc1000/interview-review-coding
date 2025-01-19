package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AscendingOrderCheck {

  private static final Logger logger = Logger.getLogger(AscendingOrderCheck.class.getName());
  public static void main(String[] args) {

    long start = System.nanoTime();
    int[] numbers = GenerateArraysOfNumbers.generateArrays(100);
    Arrays.sort(numbers);
    logger.log(Level.INFO, "::: NUMBERS -> {0} :::", Arrays.toString(numbers));
    boolean isAscending = checkAscendingOrder(numbers);

    logger.log(Level.INFO, "ASCENDING ORDER?: {0} :::", isAscending);

    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);


  }

  private static boolean checkAscendingOrder(int[] numbers) {

    // the next number must be larger than the previous
  boolean check = false;
    for (int i = 1; i < numbers.length ; i++) {
      if(numbers[i] > numbers[i-1]) {
        check = true;
      } else {
        check = false;
      }
    }

    return check;
  }
}
