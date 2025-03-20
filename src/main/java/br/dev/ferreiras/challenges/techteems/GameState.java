package br.dev.ferreiras.challenges.techteems;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class GameState {
    private Set<String> leftSide;
    private Set<String> rightSide;
    private boolean isBoatOnLeft;

    private static final String WOLF = "wolf";
    private static final String GOAT = "goat";
    private static final String CABBAGE = "cabbage";
    private static final String ALONE = "alone";

    public GameState() {
        leftSide = new HashSet<>(Set.of(WOLF, GOAT, CABBAGE));
        rightSide = new HashSet<>();
        isBoatOnLeft = true;
    }

    // Functional interface to validate move logic
    private final BiPredicate<Set<String>, String> isValidMove = (side, item) ->
            item.equals(ALONE) || side.contains(item);

    // Lambda for transferring an item
    private final Consumer<String> transferItem = item -> {
        Set<String> fromSide = isBoatOnLeft ? leftSide : rightSide;
        Set<String> toSide = isBoatOnLeft ? rightSide : leftSide;

        if (!item.equals(ALONE)) {
            fromSide.remove(item);
            toSide.add(item);
        }
        isBoatOnLeft = !isBoatOnLeft;
    };

    // Public method to make a move
    public boolean move(String item) {
        Set<String> currentSide = isBoatOnLeft ? leftSide : rightSide;

        if (!isValidMove.test(currentSide, item)) return false;

        transferItem.accept(item);
        return isValidState();
    }

    // Functional interface for state validation
    private final BiPredicate<Set<String>, Boolean> isAloneWithDanger = (side, boatLeft) ->
            (!boatLeft && (side.contains(WOLF) && side.contains(GOAT))) ||
                    (!boatLeft && (side.contains(GOAT) && side.contains(CABBAGE)));

    private boolean isValidState() {
        return !(isAloneWithDanger.test(leftSide, isBoatOnLeft) ||
                isAloneWithDanger.test(rightSide, !isBoatOnLeft));
    }

    public boolean isSolved() {
        return leftSide.isEmpty() && rightSide.containsAll(Set.of(WOLF, GOAT, CABBAGE));
    }

}
