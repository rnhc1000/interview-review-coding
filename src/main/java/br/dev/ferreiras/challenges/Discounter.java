package br.dev.ferreiras.challenges;


import static java.lang.Integer.valueOf;

public class Discounter {
  static double percent; //1
  int offset = 10;
  int base = 50; //2

  public static double calc(double value) {
    int coupon = 0;
    int offset = 0;
    int base = 0; //3
    if (percent < 10) { //4
      coupon = 15;
      offset = 20;
      base = 10;
    }
    return coupon * offset * base * value / 100; //5
  }

  public static void testInt(Integer obj, int var) {
    obj = var++;
    obj++;
  }

  public static void crazyLoop(){
    int c = 0;
    JACK: while (c < 8){
      JILL: System.out.printf("%d ", c);
      if (c > 3) break JACK; else c++;
    }
  }

  public static void main(String[] args) {
    System.out.println(calc(100));
    Integer val1 = 5;
    int val2 = 9;
    testInt(val1++, ++val2);
    System.out.println((val1+" "+ val2));
    crazyLoop();
  }
}

