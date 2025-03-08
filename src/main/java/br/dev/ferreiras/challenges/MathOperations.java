package br.dev.ferreiras.challenges;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MathOperations {

  interface Operations extends BiFunction<BigDecimal, BigDecimal, BigDecimal> {

  }

  private static final Logger logger = Logger.getLogger(MathOperations.class.getName());

  static class Operation implements Operations {

    public static BigDecimal doOperations(String mathOperation, BigDecimal x, BigDecimal y) {
      Map<String, Operations> map = new LinkedHashMap<>();
      map.put("addition", BigDecimal::add);
      map.put("subtraction", BigDecimal::subtract);
      map.put("multiplication", BigDecimal::multiply);
      map.put("division", BigDecimal::divide);

      Operations math = map.get(mathOperation);

      if (math != null) {
        return math.apply(x, y);
      } else {
        throw new UnsupportedOperationException("Operation Invalid!");
      }
    }

    @Override
    public BigDecimal apply(BigDecimal x, BigDecimal y) {
      return BigDecimal.ZERO;
    }
  }

  public static void main(String[] args) {
    BigDecimal a = BigDecimal.valueOf(10L);
    BigDecimal b = BigDecimal.valueOf(20L);
    String ops = "multiplication";

    BigDecimal result = Operation.doOperations(ops, a, b);

    logger.log(Level.INFO, "::: Result: -> {0} :::", result);

  }

}
