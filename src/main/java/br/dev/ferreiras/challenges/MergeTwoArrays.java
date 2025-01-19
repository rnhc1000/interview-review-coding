package br.dev.ferreiras.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class MergeTwoArrays {

  private static final Logger logger = Logger.getLogger(MergeTwoArrays.class.getName());

  public static void main(String[] args) {
    long start = System.nanoTime();
    int[] numbersOne = GenerateArraysOfNumbers.generateArrays(100);
    logger.log(Level.INFO, "::: ARRAY ONE: -> {0} :::", Arrays.toString(numbersOne));

    int[] numbersTwo = GenerateArraysOfNumbers.generateSortedArrays(100);
    logger.log(Level.INFO, "::: ARRAY TWO: -> {0} :::", Arrays.toString(numbersTwo));

    int[] merged = mergedArrays(numbersOne, numbersTwo);
    logger.log(Level.INFO, "::: MERGED ARRAY: -> {0} :::", Arrays.toString(merged));
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);

  }

  private static int[] mergedArrays(int[] numbersOne, int[] numbersTwo) {
    //Arrays.stream(numbersOne).distinct().map( x -> Arrays.stream(numbersTwo).distinct().map(y -> y = x)).toArray();

    List<Integer> mergedList = new ArrayList<>();

    for ( int number : numbersOne) {
      mergedList.add(number);
    }
    for (int number : numbersTwo) {
      mergedList.add(number);
    }

    return mergedList.stream().sorted().mapToInt(x -> x).toArray();
  }
}
