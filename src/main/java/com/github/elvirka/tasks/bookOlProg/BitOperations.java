package com.github.elvirka.tasks.bookOlProg;

import static java.lang.Integer.toBinaryString;

public class BitOperations {

    public static void main(String[] args) {
        int x = 32;
        System.out.println((x & x-1) == 0);
        x = 26;
        System.out.println(x);
        System.out.println(toBinaryString(x));
        System.out.println(-x);
        System.out.println(toBinaryString(-x));
        System.out.println(toBinaryString(x & -x));
        System.out.println(toBinaryString(x & 2-x));
        System.out.println(toBinaryString(x | (1<<1)));
        System.out.println(toBinaryString(x & ~(1<<2)));
        System.out.println(toBinaryString(x ^(1<<2)));
        System.out.println(toBinaryString(x & x-1));
        System.out.println((x & (1<<2)) != 0);
        System.out.println((x & (1<<1)) == 0);
    }

}
