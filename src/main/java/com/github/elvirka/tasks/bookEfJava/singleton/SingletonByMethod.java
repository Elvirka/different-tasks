package com.github.elvirka.tasks.bookEfJava.singleton;

public class SingletonByMethod {

    private static int counter = 0;

    private static final SingletonByMethod INSTANCE = new SingletonByMethod();

    public static SingletonByMethod instance(){
        return INSTANCE;
    }

    private SingletonByMethod(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }
}
