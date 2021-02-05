package com.github.elvirka.tasks.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class TryCompletableFuture {

    public static void main(String[] args) {
        testRun();
        //testAccept();
    }

    private static void testRun() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            System.out.println("EXECUTED 1!");
        };
        Runnable task2 = () -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            System.out.println("EXECUTED 2!");
        };
        CompletableFuture future = CompletableFuture
                .runAsync(task, executor)
                .thenRun(task2);
        System.out.println("Main thread " + Thread.currentThread().getName());
        future.join();
    }

    private static void testAccept() {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Supplier<String> task = () -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            return "qwe";
        };

        Consumer<String> task2 = (text) -> {
            System.out.println("Thread " + Thread.currentThread().getName());
            System.out.println(text);
        };

        CompletableFuture future = CompletableFuture
            .supplyAsync(task, executor)
            .thenAcceptAsync(task2);
        System.out.println("Main thread " + Thread.currentThread().getName());
    }
}
