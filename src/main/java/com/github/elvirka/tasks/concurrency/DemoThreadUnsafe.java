package com.github.elvirka.tasks.concurrency;

import java.util.Random;

class DemoThreadUnsafe {

    static Random random = new Random(System.currentTimeMillis());

    public static void main(String args[]) throws InterruptedException {

        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();
        Thread thread1 = new Thread( () -> {
            for (int i = 0; i < 100; i++) {
                badCounter.increment();
                DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
            }
        });

        Thread thread2 = new Thread( () -> {
            for (int i = 0; i < 100; i++) {
                badCounter.decrement();
                DemoThreadUnsafe.sleepRandomlyForLessThan10Secs();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        badCounter.printFinalCounterValue();
    }

    public static void sleepRandomlyForLessThan10Secs() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ie) {
        }
    }
}

class ThreadUnsafeCounter {

    int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    void printFinalCounterValue() {
        System.out.println("counter is: " + count);
    }
}

