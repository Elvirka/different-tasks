package com.github.elvirka.tasks.concurrency;

import java.util.ArrayList;
import java.util.List;

public class TryThread {

    public static void main(String[] args) {
        var list = new Container();
        Runnable foo = () -> {
            for (int i = 0; i < 100000; i++) {
                list.addEntry("foo");
                System.out.println("Thread " + Thread.currentThread().getName());
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

class Container {
    private final List<String> list = new ArrayList<>();

    synchronized public void addEntry(String s) {
        list.add(s);
    }

    public Integer size(){
        return list.size();
    }
}