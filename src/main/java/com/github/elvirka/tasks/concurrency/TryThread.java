package com.github.elvirka.tasks.concurrency;

import java.util.ArrayList;

public class TryThread {

    public static void main(String[] args) throws InterruptedException {
        var list = new Container();
        Runnable foo = () -> {
            for (int i = 0; i < 100000; i++) {
                list.addEntry("foo");
            }
        };
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            var thread = new Thread(foo);
            thread.start();
            threads.add(thread);
        }
        System.out.println(list.size());
        while (list.size() < 1000000){}
        System.out.println("Finished!");
    }
}