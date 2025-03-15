package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
You are given an integer array nums.
You are initially positioned at the array's first index, and each element in the array represents your maximum jump
length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible
to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105
 */
public class JumpGame {

  private static final Logger logger = Logger.getLogger(JumpGame.class.getName());

  public static void main(String[] args) {
    long start = System.nanoTime();
//    int[] numbers = GenerateArraysOfNumbers.generateUniqueArrays(20);
    int[] numbers = {2, 3, 1, 1, 4};
    logger.log(Level.INFO, "CAN I JUMP: {0}  :::", Arrays.toString(numbers));

    boolean response = canJump(numbers);
    logger.log(Level.INFO, "CAN I JUMP: {0}  :::", response);
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  public static boolean canJump(int[] numbers) {

    boolean jump = false;
    int size = numbers.length;
    for (int i = 1; i < size; i++) {
      int distance = size - 1 - i;
      if (numbers[i] == distance) {
        jump = true;
        break;
      } else {
        jump = false;
      }
    }
    
    return jump;
  }
}
