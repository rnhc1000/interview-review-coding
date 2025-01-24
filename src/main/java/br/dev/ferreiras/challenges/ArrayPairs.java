package br.dev.ferreiras.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
A non-empty array A consisting of N integers is given.
The array contains an odd number of elements, and each element of the array can be paired with
another element that has the same value, except for one element that is left unpaired.

For example, in array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the elements at indexes 0 and 2 have value 9,
the elements at indexes 1 and 3 have value 3,
the elements at indexes 4 and 6 have value 9,
the element at index 5 has value 7 and is unpaired.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers fulfilling the above conditions, returns the value of the unpaired element.

For example, given array A such that:

  A[0] = 9  A[1] = 3  A[2] = 9
  A[3] = 3  A[4] = 9  A[5] = 7
  A[6] = 9
the function should return 7, as explained in the example above.

Write an efficient algorithm for the following assumptions:

N is an odd integer within the range [1..1,000,000];
each element of array A is an integer within the range [1..1,000,000,000];
all but one of the values in A occur an even number of times.

 */
public class ArrayPairs {

  private static final Logger logger = Logger.getLogger(ArrayPairs.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    int[] numbers = GenerateArraysOfNumbers.generateUniqueArraysOfPairs(100);
    int response = unpaired(numbers);
    logger.log(Level.INFO, "::: UNPAIRED: {0} ::::", response);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }
  public static int pairs(int[] numbers) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int num : numbers) {

      if (map.containsKey(num)) {

        map.put(num, map.getOrDefault(num, 0) + 1);
      } else {
        map.put(num, 1);
      }
    }

    List<Integer> list = new ArrayList<>();
      for (Map.Entry<Integer,Integer> mapEntry : map.entrySet()) {

        if(mapEntry.getValue() == 1) {
          list.add(mapEntry.getKey());
        }

      }

    return list.get(0);
  }

  public static int unpaired(int[] numbers) {

    int unpaired = 0;

    for(int number : numbers) {
      unpaired = unpaired  ^ number;
    }

    return unpaired;
  }
}
