package br.dev.ferreiras.challenges;

import java.util.logging.Logger;
import java.util.logging.Level;

public class ThreadsOrder {
    static int x = 0;
    static int y = 0;
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread t2 = new Thread( () -> {
            b = 1;
            y = a;
        });

        t1.start();
        t2.start();
//        t1.join();
//        t2.join();

        Logger.getGlobal().log(Level.INFO, () ->
                String.format(
                        "::: x=%s, y=%s :::",x, y));
    }
}
