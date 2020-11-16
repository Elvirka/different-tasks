package codeforces.com.tasks.bookEfJava.singleton;

public class SingletonByField {

    private static int counter = 0;

    public static final SingletonByField INSTANCE = new SingletonByField();

    private SingletonByField(){
        counter++;
    }

    public int getCounter(){
        return counter;
    }
}
