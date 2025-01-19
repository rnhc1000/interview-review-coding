package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DigitsSum {

  private static final Logger logger = Logger.getLogger(DigitsSum.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    int number = 777777;

    int sum = sumUp(number);

    logger.log(Level.INFO, "SUM OF ALL DIGITS: {0}  :::", sum);
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static int sumUp(int number) {
/*
        unidade = ((numero/1)%10)*1
 *         dezena = ((numero/10)%10)*10
 *         centena = ((numero/100)%10)*100
 *         u_milhar = ((numero/1000)%10)*1000
 *         d_milhar = ((numero/10000)%10)*1000
 */
    int sum = 0;
    while (number != 0) {
      sum += number % 10;
      number /= 10;
    }

    return sum;
  }

}
