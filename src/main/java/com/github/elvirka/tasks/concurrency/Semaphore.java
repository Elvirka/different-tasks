package com.github.elvirka.tasks.concurrency;

import java.util.concurrent.Semaphore;

class SemaphoreDemonstration {
    public static void main(String args[]) throws InterruptedException {
        TrySemaphore.example();
    }
}

class TrySemaphore {
    public static void example() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);

        Thread badThread = new Thread(() -> {
            while (true) {
                try {
                    semaphore.acquire();
                    try {
                        throw new RuntimeException("");
                    } catch (Exception e) {
                        return;
                    } finally {
                        System.out.println("Bad thread releasing semaphore.");
                        semaphore.release();
                    }
                } catch (InterruptedException ie) {
                    // handle thread interruption
                }
            }
        });

        badThread.start();

        Thread.sleep(1000);

        final Thread goodThread = new Thread(() -> {
            System.out.println("Good thread patiently waiting to be signalled.");
            try {
                semaphore.acquire();
            } catch (InterruptedException ie) {
                // handle thread interruption
            }
        });

        goodThread.start();
        badThread.join();
        goodThread.join();
        System.out.println("Exiting Program");
    }
}
