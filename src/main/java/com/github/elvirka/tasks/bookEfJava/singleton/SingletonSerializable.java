package com.github.elvirka.tasks.bookEfJava.singleton;

import java.io.Serializable;

public class SingletonSerializable implements Serializable {

    private static int counter = 0;

    public static final SingletonSerializable INSTANCE = new SingletonSerializable();

    private SingletonSerializable(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }

    private Object readResolve(){
        return INSTANCE;
    }
}
