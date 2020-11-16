package com.github.elvirka.tasks.concurrency;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private final List<String> list = new ArrayList<>();

    synchronized public void addEntry(String s) {
        list.add(s);
    }

    public Integer size(){
        return list.size();
    }
}
