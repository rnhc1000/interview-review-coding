package br.dev.ferreiras.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
  private List<List<int[]>> solutions = new ArrayList<>();

  public List<List<int[]>> solveNQueens(int n) {
    int[] positions = new int[n]; // This will store the row for each column
    solve(0, positions, n);
    return solutions;
  }

  private void solve(int currentCol, int[] positions, int n) {
    if (currentCol == n) {
      buildSolution(positions);
      return;
    }

    for (int row = 0; row < n; row++) {
      if (isValid(row, currentCol, positions)) {
        positions[currentCol] = row; // Place queen
        solve(currentCol + 1, positions, n);
      }
    }
  }

  private boolean isValid(int row, int col, int[] positions) {
    for (int i = 0; i < col; i++) {
      // Check column and diagonal conflicts
      if (positions[i] == row || Math.abs(positions[i] - row) == Math.abs(i - col)) {
        return false;
      }
    }

    return true;
  }

  private void buildSolution(int[] positions) {
    List<int[]> solution = new ArrayList<>();
    for (int col = 0; col < positions.length; col++) {
      solution.add(new int[]{col, positions[col]}); // Store column and row index
    }
    solutions.add(solution);
  }

  public static void main(String[] args) {
    NQueens queen = new NQueens();
    int n = 4; // Change this value to test different sizes of the board
    List<List<int[]>> results = queen.solveNQueens(n);
    for (List<int[]> result : results) {
      System.out.print("[");
      result.forEach(position -> System.out.printf("%d ",(position[1]+1)));
      System.out.print("]");
    }
  }
}
