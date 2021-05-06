package com.github.elvirka.tasks.concurrency;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class TryCopyOnWriteArrayListIterator {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();

        Iterator itr = list.iterator();
        list.add("GfG");
        System.out.println("List contains: ");
        while (itr.hasNext())
            System.out.println(itr.next());
        
        itr = list.iterator();
        System.out.println("List contains:");
        while (itr.hasNext())
            System.out.println(itr.next());
    }
}