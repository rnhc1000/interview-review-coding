package br.dev.ferreiras.challenges;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NumberOfVowels {

  private static final Logger logger = Logger.getLogger(NumberOfVowels.class.getName());

  public static void main(String[] args) {

    long start = System.nanoTime();
    String string = """
        
        Silent configuration file
        You can download the default silent configuration file for IntelliJ IDEA at https://download.jetbrains.com/idea/silent.config
        The silent configuration file defines the options for installing IntelliJ IDEA. With the default options, silent installation 
        is performed only for the current user: mode=user. 
        If you want to install IntelliJ IDEA for all users, change the value of the installation mode option to mode=admin and run 
        the installer as an administrator.
        The default silent configuration file is unique for each JetBrains product. You can modify it to enable or disable various 
        installation options as necessary.
        It is possible to perform silent installation without the configuration file. 
        In this case, omit the /CONFIG switch and run the installer as an administrator. 
        Without the silent configuration file, the installer will ignore all additional options: 
        it will not create desktop shortcuts, add associations, or update the PATH variable. 
        However, it will still create a shortcut in the Start menu under JetBrains.

        """;

    int numberOfVowels = getVowels(string);
    logger.log(Level.INFO, "::: NUMBER OF VOWELS: -> {0} :::", numberOfVowels);
    logger.log(Level.WARNING, "::: TIME SPENT spent: {0} ms ::: ", (System.nanoTime() - start)/ 1_000_000);
  }

  private static int getVowels(String string) {

//    string = string.toLowerCase();
    Map<Character, Integer> map = Map.ofEntries(
        Map.entry('a',65),
        Map.entry('A',65),

        Map.entry('e',69),
        Map.entry('E',65),

        Map.entry('i',73),
        Map.entry('I',65),

        Map.entry('o',79),
        Map.entry('O',65),

        Map.entry('u',85),
        Map.entry('U',65)

        );
    logger.log(Level.INFO, "Map of characters {0}", map);

    int count = 0;
    for (char ch : string.toCharArray()) {
      if(map.containsKey(ch)) count++;
    }

    return count;
  }

}
