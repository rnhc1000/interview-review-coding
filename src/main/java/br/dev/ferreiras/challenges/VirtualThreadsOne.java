package br.dev.ferreiras.challenges;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class VirtualThreadsOne {

  private static final Logger logger = Logger.getLogger(VirtualThreadsOne.class.getName());

  public static void main(String[] args) throws InterruptedException{
    Set<String> poolNames = ConcurrentHashMap.newKeySet();
    Set<String> threadNames = ConcurrentHashMap.newKeySet();

    List<Thread> threads = IntStream.range(0, 100).mapToObj(i -> Thread.ofVirtual().unstarted( ()-> {
      String poolName = readPoolName();
      poolNames.add(poolName);
      String workerName = readWorkerName();
      threadNames.add(workerName);
    })).toList();

    logger.log(Level.INFO, "Threads {0}", threads);

    Instant begin = Instant.now();
    threads.forEach(Thread::start);
    for (Thread thread : threads) {
      thread.join();
    }
    Instant end = Instant.now();
    logger.log(Level.INFO, "Time = {0} ms", Duration.between(begin, end).toMillis());
    logger.log(Level.INFO, "# of cores = {0}", Runtime.getRuntime().availableProcessors());
    logger.log(Level.INFO, "Pools = {0}", poolNames);
    logger.log(Level.INFO, "Platform Threads: = {0}", threadNames);

  }

  private static String readPoolName() {
    // Mock implementation: returning a pool name based on current thread hash
    return "Pool-" + Thread.currentThread().hashCode();
  }

  private static String readWorkerName() {
    // Mock implementation: returning a worker name based on current thread ID
    return "Worker-" + Thread.currentThread().threadId();
  }
}
