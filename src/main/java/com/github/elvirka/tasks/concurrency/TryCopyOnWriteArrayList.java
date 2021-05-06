package com.github.elvirka.tasks.concurrency;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class TryCopyOnWriteArrayList extends Thread {

    static List<String> l = new CopyOnWriteArrayList<>();
    public void run() {
        l.add("D");
    }

    public static void main(String[] args) throws InterruptedException {
        l.add("A"); l.add("B"); l.add("c");

        TryCopyOnWriteArrayList t = new TryCopyOnWriteArrayList();
        t.run();

        Thread.sleep(1000);

        Iterator itr = l.iterator();
        while (itr.hasNext()) {
            String s = (String)itr.next();
            System.out.println(s);
            Thread.sleep(1000);
        }
        System.out.println(l);
    }
}

