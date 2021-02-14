package com.github.elvirka.tasks;

import java.util.ArrayList;

public class Program {
    static Object lock = new Object();
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        runThread();
    }

    static public void runThread() {
        var list = new ArrayList<Thread>();

        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(() -> {
                synchronized (lock) {
                    for (int j = 0; j < 1000000; j++) {
                        counter++;
                    }
                }
            });
            list.add(t1);
        }
        list.forEach(Thread::start);
    }
}