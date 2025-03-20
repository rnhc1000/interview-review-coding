package br.dev.ferreiras.challenges.techteems;

public class Validator {
    public static boolean validateGame(String[] moves) {
        GameState gameState = new GameState();

        for (String move : moves) {
            move = move.trim().toLowerCase();

            if (!gameState.move(move)) {
                return false; // Invalid move sequence
            }
        }

        return gameState.isSolved();
    }
}
