package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
    int[] numbers = GenerateArraysOfNumbers.generateArrays(20);
    int result = findMinimum(numbers);
    int k = 5;
    int[] prefix = sum(numbers, k);
    int max = targetSum(numbers, k);
    logger.log(Level.INFO, "::: MINIMUM VALUE: {0} ::::", result);
    logger.log(Level.INFO, "::: NUMBERS: {0} :::", Arrays.toString(numbers));
    logger.log(Level.INFO, "::: PREFIXSUM OF NUMBERS: {0} :::", Arrays.toString(prefix));
    logger.log(Level.INFO, "::: MAX: {0} :::", max);
    logger.log(Level.INFO, "::: TARGET: {0} :::", k);

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
      int left = prefixSum[i - 1];
      int right = sum - left;
      int current = Math.abs(left - right);

      if (current < min) {
        min = current;
      }
    }
    return min;
  }

  private static int[] sum(int[] numbers, int k) {

    int size = numbers.length;
    int[] prefixSumOne = new int[size +1];
    int[] prefixSumTwo = new int[size];

//    prefixSumOne[0] = numbers[0];
    for (int i = 1; i <= size; i++) {
      prefixSumOne[i] = prefixSumOne[i - 1] + numbers[i-1];
    }

    prefixSumTwo[0] = numbers[0];
    for (int i = 1; i <size; i++) {
      prefixSumTwo[i] = prefixSumTwo[i-1] + numbers[i];
    }

    logger.log(Level.INFO, "::: NUMBERS: -> {0} :::", Arrays.toString(numbers));
    logger.log(Level.INFO, "::: PREFIXSUM ONE: -> {0} :::", Arrays.toString(prefixSumOne));
    logger.log(Level.INFO, "::: PREFIXSUM TWO: -> {0} :::", Arrays.toString(prefixSumTwo));


    return prefixSumOne; // [1, 3, 6, 10, 15] - [ 1, 2, 3, 4, 5]
  }
/*
Sum of Subarrays:
Once you have the prefix sum array, you can calculate the sum of any subarray between indexes i and j using the formula:
sum=prefix[j+1]−prefix[i]
 */
  public static int targetSum(int[] numbers, int target) {

    int size = numbers.length;
    int[] prefix = new int[size + 1];

    for (int i =1; i <=size; i++) {
      prefix[i] = prefix[i-1] + numbers[i-1];
    }

    int max = Integer.MIN_VALUE;

    for (int i=0; i <= size -target; i++) {

      int currentSum = prefix[i + target] - prefix[i];

      max = Math.max(max, currentSum);
    }


    return max == Integer.MIN_VALUE ? 0 : max;
  }
}
