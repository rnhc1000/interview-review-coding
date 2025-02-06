package br.dev.ferreiras.challenges;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FizzBuzz {

  private final static Logger logger = Logger.getLogger(FizzBuzz.class.getName());

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Input a number ->:");
    int number = input.nextInt();
    int n = fizzBuzz(number);
    logger.log(Level.INFO, "N is divisible by {0}", n);
  }

  private static int fizzBuzz(int number) {

    for (int i = 1; i <= number; i++) {
      String response = check(i);

      switch (response) {
        case "fifteen" -> logger.log(Level.INFO, "FuzzBuzz");
        case "three" -> logger.log(Level.INFO, "Fuzz");
        case "five" -> logger.log(Level.INFO, "Buzz");
        default -> logger.log(Level.INFO, "::: i: {0} ::::", i);
      }
    }
    return 1;
  }

  private static String check(int i) {
    if (i % 15 == 0) return "fifteen";
    if (i % 3 == 0) return "three";
    if (i % 5 == 0) return "five";
    return "zero";
  }
}
