package br.dev.ferreiras.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InstanceOf {

  static class Student {
  }

  static class Rockstar {
  }

  static class Hacker {
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int number = Integer.parseInt(bufferedReader.readLine().trim());

    List<Object> list = new ArrayList<>();
    while (number > 0) {
      String input = bufferedReader.readLine().trim();
      switch (input) {
        case "Student" -> list.add(new Student());
        case "Rockstar" -> list.add(new Rockstar());
        case "Hacker" -> list.add(new Hacker());
        default -> throw new IllegalStateException("Unexpected value: " + input);
      }
      number--;
    }
    int countStudent = 0;
    int countRockstar = 0;
    int countHacker = 0;

    for (Object object : list) {
      if (object instanceof Student) countStudent++;
      if (object instanceof Rockstar) countRockstar++;
      if (object instanceof Hacker) countHacker++;

    }

    bufferedReader.close();
    System.out.printf("%d %d %d", countStudent, countRockstar, countHacker);


  }
}
