package com.github.elvirka.tasks.bookEfJava.singleton;

public enum SingletonByEnum {
    INSTANCE();

    private static int counter = 0;

    public int getCounter(){
        return counter;
    }
}
