package br.dev.ferreiras.challenges.techteems;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String filePath = "/home/rferreira/dev/interviewcoding/src/main/java/br/dev/ferreiras/challenges/techteems/game_moves.csv"; // CSV file path
        List<String[]> moveSequences = CsvReader.readCsv(filePath);

        int gameNumber = 1;
        for (String[] moves : moveSequences) {
            boolean isValid = Validator.validateGame(moves);
            System.out.println("Game " + gameNumber + ": " + (isValid ? "SUCCESS" : "FAILURE"));
            gameNumber++;
        }
    }
}
