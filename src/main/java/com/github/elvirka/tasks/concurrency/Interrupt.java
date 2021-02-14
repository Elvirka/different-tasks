package com.github.elvirka.tasks.concurrency;

class InterruptDemonstration {

    public static void main(String[] args) throws InterruptedException {
        Interrupt.example();
    }
}

class Interrupt {

    static public void example() throws InterruptedException {

        final Thread sleepyThread = new Thread(() -> {
            try {
                System.out.println("Sleep");
                Thread.sleep(1000 * 60 * 60);
            } catch (InterruptedException ie) {
                System.out.println("Interrupt : " + Thread.interrupted() + " " + Thread.currentThread().isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println("Interrupted : " + Thread.currentThread().isInterrupted() + " " + Thread.interrupted());

            }
        });

        sleepyThread.setName("qwe");
        sleepyThread.start();

        System.out.println("Wake up the sleepy thread ...");
        sleepyThread.interrupt();
        System.out.println("Woke up sleepy thread ...");

        sleepyThread.join();
    }
}
