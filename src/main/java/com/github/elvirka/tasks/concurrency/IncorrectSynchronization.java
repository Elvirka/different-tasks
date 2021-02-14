package com.github.elvirka.tasks.concurrency;

class IncorrectSynchronizationDemonstration {
    public static void main( String args[] ) throws InterruptedException {
        IncorrectSynchronization.runExample();
    }
}

class IncorrectSynchronization {

    Boolean flag = Boolean.TRUE;

    public void example() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (flag) {
                try {
                    while (flag) {
                        System.out.println("First thread about to sleep");
                        Thread.sleep(5000);
                        System.out.println("Woke up and about to invoke wait()");
                        flag.wait();
                    }
                } catch (InterruptedException ignored) {

                }
            }
        });

        Thread t2 = new Thread(() -> {
            flag = false;
            System.out.println("Boolean assignment done.");
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
        t1.join();
        t2.join();
    }

    public static void runExample() throws InterruptedException {
        IncorrectSynchronization incorrectSynchronization = new IncorrectSynchronization();
        incorrectSynchronization.example();
    }
}
