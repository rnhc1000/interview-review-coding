package br.dev.ferreiras.challenges;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SumAllElements {

private static final Logger logger = Logger.getLogger(SumAllElements.class.getName());

  public static void main(String[] args) {
    long start = System.nanoTime();
    int[] numbers = GenerateArraysOfNumbers.generateArrays(20);
    int sum = addNumbers(numbers);
    List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);
    logger.log(Level.INFO, "::: Sum of all numbers: -> {0} :::", sum);
    sum = addNumbers(list);

    logger.log(Level.INFO, "::: Sum of all numbers: -> {0} :::", sum);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start)/ 1_000_000);
  }

  private static int addNumbers(int[] numbers) {

    int sum = 0;

    for(int number : numbers) {
      sum+=number;
    }
    return sum;
  }

  private static int addNumbers(List<Integer> list) {

    return list.stream().mapToInt(x -> x).sum();
    //return list.stream().reduce(0, Integer::sum);
    //list.stream().reduce(0, (x,y) -> x + y)
  }
}
