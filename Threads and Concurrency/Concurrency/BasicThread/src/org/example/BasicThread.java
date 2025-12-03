package org.example;

public class BasicThread {
    private BasicThread() {}

    public static boolean started(Thread a, Thread b, Thread c) {
        a.start();
        b.start();
        c.start();
        return true;
    }
    public static boolean completed(Thread a, Thread b, Thread c) {
        try {
            a.join();
            b.join();
            c.join();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}