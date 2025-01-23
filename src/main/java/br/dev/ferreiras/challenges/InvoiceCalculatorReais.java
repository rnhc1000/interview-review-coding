package br.dev.ferreiras.challenges;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class InvoiceCalculatorReais {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Set locale for Brazilian currency formatting
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    // Input service start date, end date, and daily rate
    System.out.print("Digite a data de início (aaaa-mm-dd): ");
    LocalDate startDate = LocalDate.parse(scanner.nextLine());

    System.out.print("Digite a data de término (aaaa-mm-dd): ");
    LocalDate endDate = LocalDate.parse(scanner.nextLine());

    System.out.print("Digite a tarifa diária (em R$): ");
    BigDecimal dailyRate = scanner.nextBigDecimal();

    // Calculate the number of days between start and end dates
    long days = ChronoUnit.DAYS.between(startDate, endDate);
    if (days <= 0) {
      System.out.println("Período de datas inválido.");
      return;
    }

    // Calculate base amount
    BigDecimal baseAmount = dailyRate.multiply(BigDecimal.valueOf(days));

    // Input payment due date and payment date
    System.out.print("Digite a data de vencimento (aaaa-mm-dd): ");
    LocalDate dueDate = LocalDate.parse(scanner.next());

    System.out.print("Digite a data de pagamento (aaaa-mm-dd): ");
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
    System.out.println("\n=== Resumo da Fatura ===");
    System.out.println("Período de Serviço: " + startDate + " a " + endDate);
    System.out.println("Número de Dias: " + days);
    System.out.println("Tarifa Diária: " + currencyFormat.format(dailyRate));
    System.out.println("Valor Base: " + currencyFormat.format(baseAmount));
    System.out.println("Dias em Atraso: " + (overdueDays > 0 ? overdueDays : 0));
    System.out.println("Multa: " + currencyFormat.format(penalty));
    System.out.println("Valor Total: " + currencyFormat.format(totalAmount));
  }
}
