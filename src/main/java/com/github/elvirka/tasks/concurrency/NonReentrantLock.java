package com.github.elvirka.tasks.concurrency;

class NonReentrantLockDemonstration {
    public static void main(String args[]) throws Exception {
        NonReentrantLock nreLock = new NonReentrantLock();

        nreLock.lock();
        System.out.println("Acquired first lock");

        System.out.println("Trying to acquire second lock");
        nreLock.lock();
        System.out.println("Acquired second lock");
    }
}

class NonReentrantLock {
    boolean isLocked;

    public NonReentrantLock() {
        isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}
