package br.dev.ferreiras.challenges;

import java.util.Arrays;
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

    return Arrays.stream(numbers).distinct().toArray();
  }
}
