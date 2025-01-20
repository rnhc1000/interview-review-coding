package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DigitsSum {

  private static final Logger logger = Logger.getLogger(DigitsSum.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    int number = 123456789;

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

  private static int sumUpNine(int number) {
/*
We know that every number in the decimal system can be expressed as a sum of its digits multiplied by powers of 10.
For example, a number represented as abcd can be written as follows:

abcd = a*10^3 + b*10^2 + c*10^1 + d*10^0

We can separate the digits and rewrite this as:
abcd = a + b + c + d + (a*999 + b*99 + c*9)
abcd = a + b + c + d + 9*(a*111 + b*11 + c)

This implies that any number can be expressed as the sum of its digits plus a multiple of 9.
So, if we take modulo with 9 on each side,
abcd % 9 = (a + b + c + d) % 9 + 0

This means that the remainder when abcd is divided by 9 is equal to the remainder where the
sum of its digits (a + b + c + d) is divided by 9.
 */

    if (number == 0) return number;

    if (number % 9 == 0) return 9;

    return number % 9;
  }

}
