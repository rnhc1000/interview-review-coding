package br.dev.ferreiras.challenges;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FisherYates {

  private static final Logger logger = Logger.getLogger(FisherYates.class.getName());
  private static final Random random = new Random();

  public static void main(String[] args) {
    int[] array = GenerateArraysOfNumbers.generateUniqueSortedArrays(20);
    logger.log(Level.INFO, "::: FisherYates: {0} :::", Arrays.toString(array));

    int[] fisherYates = fisherYates(array);
    logger.log(Level.INFO, "::: FisherYates: {0} :::", Arrays.toString(fisherYates));
  }

  private static int[] fisherYates(int[] array) {


    int size = array.length;

    for (int i = size - 1; i > 0; i--) {
      int j = random.nextInt(size - 1);
      logger.log(Level.INFO, "::: RANDOM J: {0} :::", j);
      array[i] ^= array[j];
//      logger.log(Level.INFO, ":::: ::::");
//      logger.log(Level.INFO, "::: ARRAY[i]: {0} :::", array[i]);
//      logger.log(Level.INFO, "::: ARRAY[j]: {0} :::", array[j]);

      array[j]  ^= array[i];
//      logger.log(Level.INFO, ":::: ::::");
//      logger.log(Level.INFO, "::: ARRAY[i]: {0} :::", array[i]);
//      logger.log(Level.INFO, "::: ARRAY[j]: {0} :::", array[j]);

      array[i] ^= array[j];
//      logger.log(Level.INFO, ":::: ::::");
//      logger.log(Level.INFO, "::: ARRAY[i]: {0} :::", array[i]);
//      logger.log(Level.INFO, "::: ARRAY[j]: {0} :::", array[j]);
    }

    return array;
  }
}
