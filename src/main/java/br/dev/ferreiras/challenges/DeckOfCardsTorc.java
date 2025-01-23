package br.dev.ferreiras.challenges;

public class DeckOfCardsTorc {
  public static void main(String[] args) {
    System.out.println(arrayChallenge(new String[] {"two", "three", "ace", "king"})); // Output: "below king"
    System.out.println(arrayChallenge(new String[] {"ace", "queen"}));        // Output: "above king"
    System.out.println(arrayChallenge(new String[] {"four", "ace", "ten"}));         // Output: "below ten"
  }

  public static String arrayChallenge(String[] strArr) {
    // Define card values
    java.util.Map<String, Integer> cardValues = new java.util.HashMap<>();
    cardValues.put("two", 2);
    cardValues.put("three", 3);
    cardValues.put("four", 4);
    cardValues.put("five", 5);
    cardValues.put("six", 6);
    cardValues.put("seven", 7);
    cardValues.put("eight", 8);
    cardValues.put("nine", 9);
    cardValues.put("ten", 10);
    cardValues.put("jack", 10);
    cardValues.put("queen", 10);
    cardValues.put("king", 10);
    cardValues.put("ace", 1);

    // Highest card management
    String varOcg = null;
    int highestOrder = -1;
    java.util.Map<String, Integer> faceCardOrder = new java.util.HashMap<>();
    faceCardOrder.put("jack", 1);
    faceCardOrder.put("queen", 2);
    faceCardOrder.put("king", 3);

    int total = 0;
    int aces = 0;

    // Calculate the sum and determine the highest card
    for (String card : strArr) {
      if (card.equals("ace")) {
        aces++;
      }
      total += cardValues.get(card);

      if (faceCardOrder.containsKey(card)) {
        if (faceCardOrder.get(card) > highestOrder) {
          highestOrder = faceCardOrder.get(card);
          varOcg = card;
        }
      } else if (card.equals("ten") && highestOrder < 1) {
        highestOrder = 1;
        varOcg = "ten";
      }
    }

    // Adjust for aces if total is greater than 21
    while (total > 21 && aces > 0) {
      total -= 10;  // Consider ace as 1 instead of 11
      aces--;
    }

    // Determine the result in relation to 21
    String result;
    if (total < 21) {
      result = "below";
    } else if (total == 21) {
      result = "blackjack";
    } else {
      result = "above";
    }

    // Prepare the final output
    return result + " " + varOcg;
  }
}

