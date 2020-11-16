package codeforces.com.tasks;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Program {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ExecutorService executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        var qwe = new SharedObject();
        executor.execute(qwe::perform);
        executor.execute(qwe::perform);
        executor.execute(qwe::perform);
        executor.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println(qwe.counter);
    }

    public static class SharedObject {
        //...
        ReentrantLock lock = new ReentrantLock();
        int counter = 0;

        public void perform() {
            lock.lock();
            try {
                counter++;
            } finally {
                lock.unlock();
            }
        }
    }

}