package br.dev.ferreiras.challenges;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Logger {

    private final PrintWriter writer;

    private Logger() {
        try {
            writer = new PrintWriter(new FileWriter("app.log", true), true);
        } catch(IOException exception) {

            throw new RuntimeException("Unable to initialize logger");
        }
    }

    private static final class InstanceHolder {
        private static final Logger instance = new Logger();
    }

    public static Logger getInstance(){

        return InstanceHolder.instance;
    }

    public void log(String... messages) {

        for (String message : messages) {
            writer.println(LocalDateTime.now() + " - " + message);
        }

    }
}
