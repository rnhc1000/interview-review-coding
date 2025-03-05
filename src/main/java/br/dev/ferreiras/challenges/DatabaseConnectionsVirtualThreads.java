package br.dev.ferreiras.challenges;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnectionsVirtualThreads {
  private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/calculator";
  private static final String USER = "adminCalculator";
  private static final String PASS = "@c4lc5l4t0r@";

  private static final Logger logger = Logger.getLogger(DatabaseConnectionsVirtualThreads.class.getName());

  public static void main(String[] args) {

    logger.log(Level.INFO, "::: STARTING .... :::");
    // Using the virtual thread executor to manage database connections
    try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

      for (int i = 0; i < 10; i++) {
        int taskId = i;
        executor.submit(() -> {
          try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
               Statement stmt = conn.createStatement();
               ResultSet rs = stmt.executeQuery("SELECT count(*) FROM tb_records;")) {

            while (rs.next())
              Logger.getGlobal().log(Level.INFO, () ->
                  {
                    try {
                      return String.format("Task : %s, - Value: %s", taskId, rs.getString("count"));
                    } catch (SQLException e) {
                      throw new RuntimeException(e);
                    }
                  }
              );

          } catch (SQLException e) {
            logger.log(Level.INFO, "Something bad happened! {0}", e.getMessage());

          }
        });
      }

      executor.shutdown();
      logger.log(Level.INFO, "::: STOPPING! .... :::");
    }
  }
}
