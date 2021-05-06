package com.github.elvirka.tasks.educative;

import com.github.elvirka.tasks.educative.kotlinCourse.Counter;
import com.github.elvirka.tasks.educative.kotlinCourse.CounterTop;

public class UseCounter {
    public static void main(String[] args) {
        Counter counter = Counter.create();
        System.out.println(counter.plus(counter));
        System.out.println(
            counter.map((ctr) -> ctr.plus(ctr))
        );

        try {
            counter.readFile("blah");
        } catch(java.io.FileNotFoundException ex) {
            System.out.println("File not found");
        }

        System.out.println(counter.add(3));
        System.out.println(counter.add());

        System.out.println(CounterTop.createCounter());
    }
}
