package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of:
|(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and
the sum of the second part.Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
 */
public class PrefixSum {

  private static final Logger logger = Logger.getLogger(PrefixSum.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    int[] numbers = {3, 1, 2, 4, 3};
    int result = findMinimum(numbers);
    logger.log(Level.INFO, "::: MINIMUM VALUE: {0} ::::", result);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static int findMinimum(int[] numbers) {
    int size = numbers.length;
    int[] prefixSum = new int[size];

    prefixSum[0] = numbers[0];

    for (int i = 1; i < size; i++) {
      prefixSum[i] = prefixSum[i - 1] + numbers[i];
    }

    int sum = prefixSum[size - 1];
    int min = Integer.MAX_VALUE;

    for (int i = 1; i < size; i++) {
      int left = prefixSum[i -1];
      int right = sum - left;
      int current = Math.abs(left -right);

      if(current < min) {
        min = current;
      }
    }
    return min;
  }
}
