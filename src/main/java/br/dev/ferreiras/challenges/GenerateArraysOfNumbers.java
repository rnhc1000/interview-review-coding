package br.dev.ferreiras.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateArraysOfNumbers {

  private GenerateArraysOfNumbers() {
  }

  private static GenerateArraysOfNumbers instance;

  public static GenerateArraysOfNumbers getInstance() {
    if (instance == null) {
      instance = new GenerateArraysOfNumbers();
    }
    return instance;
  }

  public static int[] generateArrays(int size) {

    Random random = new Random();
    int len = random.nextInt(size);
    int[] numbers = new int[len];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = random.nextInt(size);
    }

    return numbers;
  }

  public static int[] generateUniqueSortedArrays(int size) {

    Random random = new Random();
    int len = random.nextInt(size);
    int[] numbers = new int[len];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = random.nextInt(size);
    }
    Arrays.sort(numbers);

    return Arrays.stream(numbers).distinct().toArray();
  }

  public static int[] generateSortedArrays(int size) {

    Random random = new Random();
    int len = random.nextInt(size);
    int[] numbers = new int[len];

    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = random.nextInt(size);
    }
    Arrays.sort(numbers);

    return numbers;
  }


  public static int[] generateUniqueArrays(int size) {

    Random random = new Random();
    int len = random.nextInt(size);
    int[] numbers = new int[len];
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = random.nextInt(size);
    }
    int numSize = numbers.length;
    for (int i = numSize - 1; i > 0; i--) {
      int j = random.nextInt(numSize -1);
      numbers[i] ^= numbers[j];
      numbers[j] ^= numbers[i];
      numbers[i] ^= numbers[j];
    }

    return Arrays.stream(numbers).distinct().toArray();
  }

  public static int[] generateUniqueArraysOfPairs(int size) {

    Random random = new Random();
    int len = random.nextInt(size);
    int[] numbers = new int[len];

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < numbers.length; i += 2) {
      list.add(random.nextInt(size));
      list.add(random.nextInt(size));
    }

    System.out.println(list);
    return list.stream().mapToInt(x -> x).toArray();
  }
}
