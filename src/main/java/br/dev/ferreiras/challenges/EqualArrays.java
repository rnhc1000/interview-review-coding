package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EqualArrays {

  private static final Logger logger = Logger.getLogger(EqualArrays.class.getName());
  public static void main(String[] args) {
    long start = System.nanoTime();

    int[] numberOne = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int[] numberTwo = {1, 2, 3, 4, 5, 6, 7, 9};

    boolean isEqual = checkArrays(numberOne, numberTwo);
    logger.log(Level.INFO, "ARE ARRAYS EQUAL: {0} :::", isEqual);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);

  }

  private static boolean checkArrays(int[] numberOne, int[] numberTwo) {

    int sizeOne = numberOne.length;
    int sizeTwo = numberTwo.length;
    if ( sizeOne != sizeTwo) return false;
    int pointerOne = 0;
    int pointerTwo = 0;

    for (int i = 0; i < sizeOne ; i++) {
      if(numberOne[pointerOne] != numberTwo[pointerTwo]) {
        return false;
      } else {
        pointerOne++;
        pointerTwo++;
      }
    }
    return true;
  }
}
