package br.dev.ferreiras.challenges;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CriminalSearch {

  public static final Logger logger = Logger.getLogger(CriminalSearch.class.getName());

  public static void main(String... args) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Map<String, LinkedHashSet<String>> aliases = new HashMap<>();

    // Store criminals with original casing
    aliases.put("Paul White", new LinkedHashSet<>(Arrays.asList("Roger Night", "Peter Llong Jr.")));
    aliases.put("Roger Fedexer", new LinkedHashSet<>(Arrays.asList("Rob Ford", "Pete Lord", "Roger McWire")));
    aliases.put("Paul White Jr.", new LinkedHashSet<>()); // Empty set
    aliases.put("Red Fortress", new LinkedHashSet<>(Arrays.asList("Roger Rabbit", "Ross Winter")));
    aliases.put("Redford Fort", new LinkedHashSet<>(Arrays.asList("Red Strong", "Red Fort")));

    Scanner input = new Scanner(System.in);
    int count = 0;
    while (count < 4) {
      logger.log(Level.INFO,"Enter the name of the criminal to search:");
      String suspect = input.nextLine().trim();

      // Find and print the criminal details
      criminalDetails(aliases, suspect);
      count++;
    }
    input.close();
  }

  private static void criminalDetails(Map<String, LinkedHashSet<String>> criminals, String suspect) {
    for (String key : criminals.keySet()) {
      if (key.equalsIgnoreCase(suspect)) {  // Use equalsIgnoreCase for comparison
        LinkedHashSet<String> aliasesSet = criminals.get(key);
        String aliasText = aliasesSet.isEmpty() ? "No known aliases" : String.join(", ", aliasesSet);
        System.out.printf("First name: %s. Aliases: %s%n", key, aliasText);
        return;
      }
    }

   logger.log(Level.INFO, "::: NO MATCH! :::");
  }
}
