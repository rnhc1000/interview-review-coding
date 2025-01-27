package br.dev.ferreiras.challenges;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
A non-empty array A consisting of N integers is given.
The consecutive elements of array A represent consecutive cars on a road.

Array A contains only 0s and/or 1s:

0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N,
is passing when P is traveling to the east and Q is traveling to the west.

For example, consider array A such that:

  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).

 */
public class PassingCars {

  private static final Logger logger = Logger.getLogger(PassingCars.class.getName());
  public static void main(String[] args) {
    long start = System.nanoTime();
    int[] cars = {0, 1, 0, 1, 1};
    int passingCars = passingCars(cars);

    logger.log(Level.INFO, ":::PASSING CARS: {0} ::::", passingCars);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start) / 1_000_000);
  }

  private static int passingCars(int[] cars) {
    int size = cars.length;
    int carsWest = 0;
    int passingCars = 0;
    int[] prefixSum = new int[size + 1];
    for (int i = 0; i < size; i++) {
      if(cars[i] == 1) {
        carsWest++;
      }
      prefixSum[i+1] = prefixSum[i] + cars[i];
    }

    for (int i = 0; i < size; i++) {
      if(cars[i] == 0) {
        passingCars += carsWest - prefixSum[i];
      }
    }

    return passingCars;
  }
}
