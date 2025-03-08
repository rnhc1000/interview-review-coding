package br.dev.ferreiras.challenges;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

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

  public static final Logger logger = Logger.getLogger(VirtualThreadsTwo.class.getName());
  public static void main(String[] args) throws InterruptedException {

    var counter = new Counter();

    var t1 = Thread.ofVirtual().unstarted(() -> {

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      for (int i = 0; i < 10; i++) {
        counter.increment();

        logger.log(Level.INFO, "%d {0}", counter.getCount());

      }
    });

    var t2 = Thread.ofVirtual().unstarted(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      for (int i = 0; i < 10; i++) {
        counter.increment();
        logger.log(Level.INFO, " {0}", counter.getCount());

      }
    });

    t1.start();
    t2.start();

    t1.join();
    t2.join();
  }
}
