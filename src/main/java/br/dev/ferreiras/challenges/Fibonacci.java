package br.dev.ferreiras.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fibonacci {

  // 0 1 1 2 3 5 8 13 21 34
  private static final Logger logger = Logger.getLogger(Fibonacci.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    int number = 12;
    int[] series = generateFibonacci(number);

    logger.log(Level.INFO, "FIBONACCI: {0}  :::", Arrays.toString(series));

    List<Integer> list = new ArrayList<>();

    while (number > 0) {

      list.add(fibonacci(number));
      number--;

    }

    List<Integer> result = list.stream().sorted().toList();

    logger.log(Level.INFO, "RECURSIVE FIBONACCI : {0}  :::", result);
    logger.log(Level.INFO, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static int[] generateFibonacci(int number) {

    if ( number == 0) return new int[]{};

    List<Integer> list = new ArrayList<>();
    list.add(0);
    list.add(1);
    list.add(1);
    int count = 1;
    int index = 1;
    while (number > 0) {
      count += list.get(index);
      list.add(count);
      number--;
      index++;
    }
    return list.stream().mapToInt(x -> x).toArray();
  }

  public static int fibonacci(int number) {
    if (number <= 1) return number;
    return fibonacci(number - 1) + fibonacci(number - 2);
  }
}
