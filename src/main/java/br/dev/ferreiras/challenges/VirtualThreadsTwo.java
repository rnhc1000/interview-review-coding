package br.dev.ferreiras.challenges;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {

  private final AtomicInteger count = new AtomicInteger(0);

  public void increment() {
    count.incrementAndGet();
  }

  public int getCount() {
    return count.get();
  }
}
public class VirtualThreadsTwo {

  public static void main(String[] args) throws InterruptedException {

    var counter = new Counter();

    var t1 = Thread.ofVirtual().unstarted(() -> {

      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      for (int i = 0; i < 10; i++) {
        counter.increment();
        System.out.printf("%d ", counter.getCount());
      }
    });

    var t2 = Thread.ofVirtual().unstarted(() -> {
      try {
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      for (int i = 0; i < 10; i++) {
        counter.increment();
        System.out.printf("%d ",counter.getCount());
      }
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();
  }
}
