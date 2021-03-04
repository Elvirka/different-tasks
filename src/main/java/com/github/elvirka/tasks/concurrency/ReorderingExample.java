package com.github.elvirka.tasks.concurrency;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ReorderingExampleDemonstration {
    public static void main( String args[] ) throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            var ex = new ReorderingExample();
            list.add(ex.reorderTest());
        }
        System.out.println(list.stream().distinct().collect(Collectors.joining()));
    }
}

class ReorderingExample {
    private int ping = 0;
    private int pong = 0;
    private int foo = 0;
    private int bar = 0;

    public String reorderTest() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            foo = 1;
            ping = bar;
        });

        Thread t2 = new Thread(() -> {
            bar = 1;
            pong = foo;
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return (ping + " " + pong);
    }
}