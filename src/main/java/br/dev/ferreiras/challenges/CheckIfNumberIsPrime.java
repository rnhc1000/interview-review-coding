package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;


public class CheckIfNumberIsPrime {

  private static final Logger logger = Logger.getLogger(CheckIfNumberIsPrime.class.getName());

  public static void main(String[] args) {
    long start = System.nanoTime();
    long number = 132L;
    boolean isPrime = checkIfNumberIsPrime(number);

    logger.log(Level.INFO, "IS PRIME?: {0}  :::", isPrime);
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static boolean checkIfNumberIsPrime(long number) {

    /*
    Math condition to a number be considered prime
    divisible only by one and itself
    1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37

    instead of checking till n, we can check till √n because a larger factor of n must
    be a multiple of a smaller factor that has been already checked.
    */
    if (number <= 1) return false;

    for (int i = 2; i < Math.sqrt(number); i++) {

      if (number % i == 0) {
        return false;
      }

    }

    return true;
  }

}
