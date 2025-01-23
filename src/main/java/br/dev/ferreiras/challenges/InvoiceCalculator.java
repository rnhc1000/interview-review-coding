package br.dev.ferreiras.challenges;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class InvoiceCalculator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String pattern = "dd-MM-yyyy";
    SimpleDateFormat format = new SimpleDateFormat((pattern));
    // Input service start date, end date, and daily rate
    System.out.print("Enter start date (yyyy-mm-dd): ");
    LocalDate startDate = LocalDate.parse(scanner.nextLine());

    System.out.print("Enter end date (yyyy-mm-dd): ");
    LocalDate endDate = LocalDate.parse(scanner.nextLine());

    System.out.print("Enter daily rate: ");
    BigDecimal dailyRate = scanner.nextBigDecimal();

    // Calculate the number of days between start and end dates
    long days = ChronoUnit.DAYS.between(startDate, endDate);
    if (days <= 0) {
      System.out.println("Invalid date range.");
      return;
    }

    long minutes = ChronoUnit.MINUTES.between(startDate, endDate);
    System.out.println("MINUTES: " + minutes);
    // Calculate base amount
    BigDecimal baseAmount = dailyRate.multiply(BigDecimal.valueOf(days));

    // Input payment due date and payment date
    System.out.print("Enter due date (yyyy-mm-dd): ");
    LocalDate dueDate = LocalDate.parse(scanner.next());

    System.out.print("Enter payment date (yyyy-mm-dd): ");
    LocalDate paymentDate = LocalDate.parse(scanner.next());

    // Calculate penalty if payment is late
    long overdueDays = ChronoUnit.DAYS.between(dueDate, paymentDate);
    BigDecimal penalty = BigDecimal.ZERO;
    if (overdueDays > 0) {
      BigDecimal penaltyRate = new BigDecimal("0.02"); // 2% penalty per day
      penalty = baseAmount.multiply(penaltyRate.multiply(BigDecimal.valueOf(overdueDays)));
    }

    // Total amount
    BigDecimal totalAmount = baseAmount.add(penalty);

    // Display invoice summary
    System.out.println("\n=== Invoice Summary ===");
    System.out.println("Service Period: " + startDate + " to " + endDate);
    System.out.println("Number of Days: " + days);
    System.out.println("Daily Rate: $" + dailyRate);
    System.out.println("Base Amount: $" + baseAmount);
    System.out.println("Overdue Days: " + (overdueDays > 0 ? overdueDays : 0));
    System.out.println("Penalty: $" + penalty);
    System.out.println("Total Amount: $" + totalAmount);
  }
}
