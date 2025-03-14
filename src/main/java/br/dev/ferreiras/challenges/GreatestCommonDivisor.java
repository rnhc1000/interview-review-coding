package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GreatestCommonDivisor {

  private static final Logger logger = Logger.getLogger(GreatestCommonDivisor.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();

    int numberOne = 24;
    int numberTwo = 576;
    int gcd = greatestCommonDivisor(numberOne, numberTwo);

    logger.log(Level.INFO, "GREATEST COMMON DIVISOR #1: {0}  :::", gcd);
    gcd = greatestCommonDivisorOne(numberOne, numberTwo);

    logger.log(Level.INFO, "GREATEST COMMON DIVISOR #2: {0}  :::", gcd);
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static int greatestCommonDivisor(int numberOne, int numberTwo) {

    if (numberTwo == 0) return numberOne;

    return greatestCommonDivisor(numberTwo, numberOne % numberTwo);
  }

  private static int greatestCommonDivisorOne(int numberOne, int numberTwo) {

    for (int i = numberTwo; i > 0; i--) {

      if (numberOne % i == 0 && numberTwo % i == 0) {
        return i;
      }

    }

    return 1;
  }
}
