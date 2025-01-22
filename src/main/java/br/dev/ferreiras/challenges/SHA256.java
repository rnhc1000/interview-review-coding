package br.dev.ferreiras.challenges;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SHA256 {

  private static final Logger logger = Logger.getLogger(SHA256.class.getName());

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Input a word: ");
    String input = scanner.nextLine();

    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] encodedHash = (digest.digest(input.getBytes(StandardCharsets.UTF_8)));
      logger.log(Level.INFO, "::: ORIGINAL STRING: {0} :::", scanner);
      logger.log(Level.INFO, "::: SHA256: {0} :::", bytesTohex(encodedHash));
    } catch (NoSuchAlgorithmException e) {
      e.getMessage();
    } finally {
      scanner.close();
    }
  }

  private static String bytesTohex(byte[] hash) {
    StringBuilder string = new StringBuilder(2 * hash.length);
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xFF & hash[i]);
      if (hex.length() == 1) string.append('0');
      string.append(hex);
    }

    return string.toString().toUpperCase();
  }
}
