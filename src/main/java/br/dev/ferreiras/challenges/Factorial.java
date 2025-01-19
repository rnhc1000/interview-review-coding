package br.dev.ferreiras.challenges;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factorial {

  private static final Logger logger = Logger.getLogger(Factorial.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    long n = 100L;

    BigDecimal m = new BigDecimal(4);

    var factorial = calculateFactorialOf(m);

    logger.log(Level.INFO, "FACTORIAL OF: {0}  :::", factorial);
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static long calculateFactorialOf(long n) {

    if (n == 1L) return 1L;

    return n * calculateFactorialOf(n - 1);
  }

  private static BigDecimal calculateFactorialOf(BigDecimal n) {

    if (n.equals(BigDecimal.ONE)) return BigDecimal.ONE;

    return n.multiply(calculateFactorialOf(n.subtract(BigDecimal.ONE)));
  }
}
